package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import java.time.LocalTime;

public record ConfiguracaoDTO(
        Long id,
        LocalTime horaInicioFuncionamento,
        LocalTime horaFimFuncionamento,
        Integer limiteCapacidade,
        Double valorMulta,
        Integer tempoMaximoPermanencia
) {}
