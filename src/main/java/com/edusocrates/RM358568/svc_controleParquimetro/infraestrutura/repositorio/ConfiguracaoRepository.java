package com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
    Optional<Configuracao> findTopByOrderByIdAsc();
}
