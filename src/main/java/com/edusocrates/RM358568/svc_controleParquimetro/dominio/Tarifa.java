package com.edusocrates.RM358568.svc_controleParquimetro.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valorPorHora;

    @Column(nullable = false)
    private Double valorPorMinuto;

    @Column(nullable = false)
    private Double multaAtraso;
}
