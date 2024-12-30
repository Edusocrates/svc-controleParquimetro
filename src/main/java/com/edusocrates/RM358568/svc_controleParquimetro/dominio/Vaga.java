package com.edusocrates.RM358568.svc_controleParquimetro.dominio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.StatusVaga;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vagas")
@Data
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusVaga status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configuracao_id", nullable = false)
    private Configuracao configuracao;  // Relacionamento com Configuração

    public boolean estaOcupada() {
        return this.status == StatusVaga.OCUPADA;
    }
}
