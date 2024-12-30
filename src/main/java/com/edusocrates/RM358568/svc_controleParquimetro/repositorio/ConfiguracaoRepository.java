package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
    Configuracao findTopByOrderByIdDesc();  // Obter a configuração mais recente
}
