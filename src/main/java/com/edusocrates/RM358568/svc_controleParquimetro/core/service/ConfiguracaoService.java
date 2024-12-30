package com.edusocrates.RM358568.svc_controleParquimetro.core.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Configuracao;
import com.edusocrates.RM358568.svc_controleParquimetro.repositorio.ConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    public Configuracao getConfiguracaoAtual() {
        return configuracaoRepository.findTopByOrderByIdDesc();
    }

    @Transactional
    public Configuracao atualizarConfiguracao(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }
}
