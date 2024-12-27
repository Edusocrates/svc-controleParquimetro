package com.edusocrates.RM358568.svc_controleParquimetro.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs_sistema")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogSistema {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String acao;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column
    private String detalhes;
}
