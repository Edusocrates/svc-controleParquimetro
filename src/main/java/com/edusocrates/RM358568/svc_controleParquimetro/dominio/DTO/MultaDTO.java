package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Multa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MultaDTO(
        Long id,
        Long veiculoId,
        BigDecimal valor,
        String descricao,
        LocalDateTime dataAplicacao
) {

    public MultaDTO(Multa multa) {
        this(
                multa.getId(),
                multa.getVeiculo().getId(),
                multa.getValor(),
                multa.getDescricao(),
                multa.getDataAplicacao()
        );
    }
}
