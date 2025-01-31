package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.impl;

import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.VagaService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Configuracao;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VagaDTO;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.StatusVaga;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Vaga;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.ConfiguracaoRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VagaServiceImpl implements VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    @Override
    public VagaDTO criarVaga(VagaDTO vagaDTO) {
        Vaga vaga = new Vaga();
        vaga.setNumero(vagaDTO.numero());
        vaga.setStatus(StatusVaga.LIVRE);

        Configuracao configuracao = configuracaoRepository.findById(vagaDTO.configuracaoId()).orElseThrow(RuntimeException::new);
        vaga.setConfiguracao(configuracao);
        Vaga vagaSalva = vagaRepository.save(vaga);
        return vagaDTO.toDTO(vagaSalva);
    }

    @Override
    public VagaDTO atualizarVaga(Long id, VagaDTO vagaDTO) {
        Optional<Vaga> vagaExistente = vagaRepository.findById(id);

        if (vagaExistente.isEmpty()) {
            throw new IllegalArgumentException("Vaga não encontrada para o ID informado.");
        }

        Vaga vaga = vagaExistente.get();
        vaga.setNumero(vagaDTO.numero());
        vaga.setStatus(StatusVaga.valueOf(vagaDTO.status()));
        Vaga vagaAtualizada = vagaRepository.save(vaga);

        return vagaDTO.toDTO(vagaAtualizada);
    }

    @Override
    public List<VagaDTO> listarVagas() {
        List<Vaga> vagas = vagaRepository.findAll();
        List<VagaDTO> vagaDTOList = new ArrayList<>();

        for (Vaga vaga : vagas) {

            VagaDTO vagaDTO = VagaDTO.toDTO(vaga);
            vagaDTOList.add(vagaDTO);
        }

        return vagaDTOList;
    }


    @Override
    public VagaDTO buscarVagaPorId(Long id) {
        return vagaRepository.findById(id)
                .map(VagaDTO::toDTO)  // Converte a Vaga para VagaDTO
                .orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada para o ID informado."));
    }


    @Override
    public void deletarVaga(Long id) {
        if (!vagaRepository.existsById(id)) {
            throw new IllegalArgumentException("Vaga não encontrada para o ID informado.");
        }

        vagaRepository.deleteById(id);
    }

    @Override
    public VagaDTO atualizarOcupacao(Long id, boolean ocupada) {
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada para o ID informado."));

        vaga.setStatus(ocupada ? StatusVaga.OCUPADA : StatusVaga.LIVRE);

        Vaga vagaAtualizada = vagaRepository.save(vaga);

        return VagaDTO.toDTO(vagaAtualizada);
    }

}
