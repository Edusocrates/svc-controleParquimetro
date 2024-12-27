package com.edusocrates.RM358568.svc_controleParquimetro.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "registros_estacionamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroEstacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(nullable = false)
    private LocalDateTime horaEntrada;

    @Column
    private LocalDateTime horaSaida;

    @Column
    private Double valorPago;

    @Column
    private Double multaAplicada;
}
