package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.impl;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.EstacionamentoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Configuracao;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.Status;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.StatusVaga;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Multa;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Vaga;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Veiculo;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.ConfiguracaoRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.MultaRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.VagaRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class EstacionamentoServiceImpl implements EstacionamentoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private ConfiguracaoRepository configuracaoRepository;
    @Autowired
    private MultaRepository multaRepository;

    // Registrar a entrada do veículo
    @Transactional
    @Override
    public Veiculo registrarEntrada(Long vagaId) {
        Vaga vaga = vagaRepository.findById(vagaId).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        // Verificar se a vaga está ocupada
        if (vaga.getStatus() == StatusVaga.OCUPADA) {
            throw new RuntimeException("A vaga já está ocupada");
        }

        // Registrar o veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setVaga(vaga);
        veiculo.setHoraEntrada(LocalDateTime.now());
        veiculo.setStatus(Status.EM_ESTACIONAMENTO);
        veiculo.setValorCobrado(BigDecimal.ZERO);  // Inicialmente sem valor cobrado
        veiculoRepository.save(veiculo);

        // Atualizar o status da vaga para ocupada
        vaga.setStatus(StatusVaga.OCUPADA);
        vagaRepository.save(vaga);

        return veiculo;
    }

    // Registrar a saída do veículo e calcular o valor cobrado
    @Transactional
    @Override
    public Veiculo registrarSaida(Long veiculoId) throws ChangeSetPersister.NotFoundException {
        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        if (veiculo.getStatus() == Status.SAIDO) {
            throw new RuntimeException("Veículo já saiu");
        }

        // Definir hora de saída
        veiculo.setHoraSaida(LocalDateTime.now());

        // Calcular valor cobrado
        long horasEstacionado = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida()).toHours();
        BigDecimal valorCobrado = calcularValorEstacionamento(horasEstacionado);

        veiculo.setValorCobrado(valorCobrado);
        veiculo.setStatus(Status.SAIDO);
        veiculoRepository.save(veiculo);

        // Atualizar o status da vaga para livre
        Vaga vaga = veiculo.getVaga();
        vaga.setStatus(StatusVaga.LIVRE);
        vagaRepository.save(vaga);

        // Verificar se houve multa
        verificarMulta(veiculo);

        return veiculo;
    }

    // Método para calcular o valor do estacionamento
    private BigDecimal calcularValorEstacionamento(long horasEstacionado) throws ChangeSetPersister.NotFoundException {
        Configuracao configuracao = configuracaoRepository.findTopByOrderByIdAsc().orElseThrow(ChangeSetPersister.NotFoundException::new);

        // Exemplo simples: valor cobrado por hora
        BigDecimal valorHora = BigDecimal.valueOf(5);  // Exemplo de valor por hora
        return valorHora.multiply(BigDecimal.valueOf(horasEstacionado));
    }

    // Verificar se o veículo ultrapassou o tempo máximo de permanência
    private void verificarMulta(Veiculo veiculo) throws ChangeSetPersister.NotFoundException {
        Configuracao configuracao = configuracaoRepository.findTopByOrderByIdAsc().orElseThrow(ChangeSetPersister.NotFoundException::new);

        long horasEstacionado = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida()).toHours();

        if (horasEstacionado > configuracao.getTempoMaximoPermanencia()) {
            // Criar multa
            Multa multa = new Multa();
            multa.setVeiculo(veiculo);
            multa.setValor(BigDecimal.valueOf(configuracao.getValorMulta()));
            multa.setDescricao("Multa por tempo excessivo de permanência");
            multa.setDataAplicacao(LocalDateTime.now());
            multaRepository.save(multa);
        }
    }

    // Verificar se o estacionamento atingiu a capacidade máxima
    public boolean isEstacionamentoCheio() throws ChangeSetPersister.NotFoundException {
        Configuracao configuracao = configuracaoRepository.findTopByOrderByIdAsc().orElseThrow(ChangeSetPersister.NotFoundException::new);
        long vagasOcupadas = vagaRepository.countByStatus(StatusVaga.OCUPADA);

        return vagasOcupadas >= configuracao.getLimiteCapacidade();
    }
}
