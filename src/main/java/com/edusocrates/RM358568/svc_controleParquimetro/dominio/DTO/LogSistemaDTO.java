package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import java.time.LocalDateTime;

public record LogSistemaDTO(
        Long id,
        String acao,
        LocalDateTime dataHora,
        String detalhes
) {}
