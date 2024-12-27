package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.RelatorioFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RelatorioFinanceiroRepository extends JpaRepository<RelatorioFinanceiro, Long> {

    List<RelatorioFinanceiro> findByDataBetween(LocalDate start, LocalDate end);
}
