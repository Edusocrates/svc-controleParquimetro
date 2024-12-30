package com.edusocrates.RM358568.svc_controleParquimetro.dominio;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "configuracoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hora_inicio_funcionamento", nullable = false)
    private LocalTime horaInicioFuncionamento;

    @Column(name = "hora_fim_funcionamento", nullable = false)
    private LocalTime horaFimFuncionamento;

    @Column(name = "limite_capacidade", nullable = false)
    private Integer limiteCapacidade;

    @Column(name = "valor_multa", nullable = false)
    private Double valorMulta;

    @Column(name = "tempo_maximo_permanencia_em_horas", nullable = false)
    private Integer tempoMaximoPermanencia;
}
