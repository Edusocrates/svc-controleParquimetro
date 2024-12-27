package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import java.time.LocalDateTime;

public record CapacidadeEstacionamentoDTO(
        Long id,
        Integer capacidadeAtual,
        Integer capacidadeMaxima,
        LocalDateTime ultimaAtualizacao
) {}
