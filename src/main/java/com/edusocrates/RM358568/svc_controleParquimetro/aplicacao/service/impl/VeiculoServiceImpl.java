package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.impl;

import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.VeiculoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.Status;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.StatusVaga;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Multa;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Vaga;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Veiculo;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.MultaRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.VagaRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private MultaRepository multaRepository;

    // Método para registrar a entrada de um veículo
    @Override
    public Veiculo registrarEntrada(String numeroVaga) {
        // Buscar a vaga pelo número
        Vaga vaga = vagaRepository.findByNumero(numeroVaga)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        if (vaga.getStatus() == StatusVaga.OCUPADA) {
            throw new RuntimeException("Vaga já ocupada");
        }

        // Criar o veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setVaga(vaga);
        veiculo.setHoraEntrada(LocalDateTime.now());
        veiculo.setStatus(Status.EM_ESTACIONAMENTO);

        // Salvar o veículo
        veiculoRepository.save(veiculo);

        // Atualizar o status da vaga
        vaga.setStatus(StatusVaga.OCUPADA);
        vagaRepository.save(vaga);

        return veiculo;
    }

    // Método para registrar a saída de um veículo
    @Override
    public Veiculo registrarSaida(Long veiculoId) {
        // Buscar o veículo pelo ID
        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        if (veiculo.getStatus() == Status.SAIDO) {
            throw new RuntimeException("Veículo já foi liberado");
        }

        // Registrar hora de saída
        veiculo.setHoraSaida(LocalDateTime.now());

        // Calcular o valor a ser cobrado
        BigDecimal valorCobrado = calcularValorCobrado(veiculo);
        veiculo.setValorCobrado(valorCobrado);

        // Verificar se há multa (caso ultrapasse o tempo permitido)
        verificarMulta(veiculo);

        // Atualizar status do veículo
        veiculo.setStatus(Status.SAIDO);

        // Liberar a vaga
        Vaga vaga = veiculo.getVaga();
        vaga.setStatus(StatusVaga.LIVRE);
        vagaRepository.save(vaga);

        // Salvar o veículo atualizado
        veiculoRepository.save(veiculo);

        return veiculo;
    }
    // Método para calcular o valor cobrado pelo estacionamento
    private BigDecimal calcularValorCobrado(Veiculo veiculo) {
        Duration duracao = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
        long minutos = duracao.toMinutes();
        BigDecimal valorPorMinuto = new BigDecimal("0.50"); // Exemplo: R$0,50 por minuto
        return valorPorMinuto.multiply(new BigDecimal(minutos));
    }

    // Método para verificar se há multa
    private void verificarMulta(Veiculo veiculo) {
        // Regra para multa: se ultrapassar 2 horas de estacionamento
        Duration duracao = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
        long minutos = duracao.toMinutes();

        if (minutos > 120) {
            BigDecimal valorMulta = new BigDecimal("50.00"); // Exemplo: multa de R$50,00
            Multa multa = new Multa();
            multa.setVeiculo(veiculo);
            multa.setValor(valorMulta);
            multa.setDescricao("Tempo de estacionamento excedido");
            multa.setDataAplicacao( LocalDateTime.now());
            multaRepository.save(multa);
            veiculo.setValorCobrado(veiculo.getValorCobrado().add(valorMulta)); // Acrescenta a multa ao valor cobrado
        }
    }


    private BigDecimal calcularValor(LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        long horas = java.time.Duration.between(horaEntrada, horaSaida).toHours();
        return BigDecimal.valueOf(horas * 5);  // Exemplo de cálculo: R$ 5 por hora
    }
}
