package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

public record VagaDTO(
        Long id,
        String numero,
        String status,
        Long configuracaoId
) {}