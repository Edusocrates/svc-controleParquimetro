package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Vaga;

public record VagaDTO(
        Long id,
        String numero,
        String status,
        Long configuracaoId
) {
    public static VagaDTO toDTO(Vaga vaga) {
        return new VagaDTO(
                vaga.getId(),
                vaga.getNumero(),
                vaga.getStatus().name(),
                vaga.getConfiguracao().getId()
        );
    }


}