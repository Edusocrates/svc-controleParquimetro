package com.edusocrates.RM358568.svc_controleParquimetro.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "capacidade_estacionamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CapacidadeEstacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer capacidadeAtual;

    @Column(nullable = false)
    private Integer capacidadeMaxima;

    @Column(nullable = false)
    private LocalDateTime ultimaAtualizacao;
}
