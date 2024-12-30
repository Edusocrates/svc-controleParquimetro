package com.edusocrates.RM358568.svc_controleParquimetro.core.service;


import com.edusocrates.RM358568.svc_controleParquimetro.dominio.RelatorioFinanceiro;
import com.edusocrates.RM358568.svc_controleParquimetro.repositorio.RelatorioFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioFinanceiroService {

    @Autowired
    private RelatorioFinanceiroRepository relatorioFinanceiroRepository;

    public List<RelatorioFinanceiro> buscarRelatoriosPorPeriodo(LocalDate inicio, LocalDate fim) {
        return relatorioFinanceiroRepository.findByDataBetween(inicio, fim);
    }
}
