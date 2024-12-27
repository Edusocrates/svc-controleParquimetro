package com.edusocrates.RM358568.svc_controleParquimetro.dominio;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "relatorios_financeiros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelatorioFinanceiro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Double totalReceita;

    @Column(nullable = false)
    private Double multasRecebidas;

    @Column(nullable = false)
    private Integer totalVeiculosAtendidos;
}
