package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

public record TarifaDTO(
        Long id,
        Double valorPorHora,
        Double valorPorMinuto,
        Double multaAtraso
) {}
