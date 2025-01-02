package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VagaDTO;

import java.util.List;

public interface VagaService {

    VagaDTO criarVaga(VagaDTO vagaDTO);

    VagaDTO atualizarVaga(Long id, VagaDTO vagaDTO);

    List<VagaDTO> listarVagas();

    VagaDTO buscarVagaPorId(Long id);

    VagaDTO atualizarOcupacao(Long id, boolean ocupada);

    void deletarVaga(Long id);
}
