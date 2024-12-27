package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import java.time.LocalDate;

public record RelatorioFinanceiroDTO(
        Long id,
        LocalDate data,
        Double totalReceita,
        Double multasRecebidas,
        Integer totalVeiculosAtendidos
) {}