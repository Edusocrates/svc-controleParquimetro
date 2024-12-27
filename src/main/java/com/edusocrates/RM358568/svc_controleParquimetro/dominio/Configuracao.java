package com.edusocrates.RM358568.svc_controleParquimetro.dominio;


import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private Integer capacidadeTotal;

    @Column(nullable = false)
    private String horarioFuncionamentoInicio;

    @Column(nullable = false)
    private String horarioFuncionamentoFim;

    @Column(nullable = false)
    private Double tempoMaximoPermissao; // Em horas
}
