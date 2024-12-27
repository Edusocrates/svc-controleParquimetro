package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import java.time.LocalDateTime;

public record RegistroEstacionamentoDTO(
        Long id,
        VeiculoDTO veiculo,
        LocalDateTime horaEntrada,
        LocalDateTime horaSaida,
        Double valorPago,
        Double multaAplicada
) {}
