package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.LogSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogSistemaRepository extends JpaRepository<LogSistema, Long> {

    List<LogSistema> findByDataHoraBetween(LocalDateTime start, LocalDateTime end);

    List<LogSistema> findByAcaoContaining(String acao);
}
