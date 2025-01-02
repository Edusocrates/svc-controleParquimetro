package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.Status;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VeiculoDTO(
        Long id,
        String vagaNumero,  // Alterado de vagaId para vagaNumero
        LocalDateTime horaEntrada,
        LocalDateTime horaSaida,
        BigDecimal valorCobrado,
        Status status
) {

    public VeiculoDTO(Veiculo veiculo) {
        this(
                veiculo.getId(),
                veiculo.getVaga().getNumero(),  // Acesso ao número da vaga
                veiculo.getHoraEntrada(),
                veiculo.getHoraSaida(),
                veiculo.getValorCobrado(),
                veiculo.getStatus()
        );
    }
}
