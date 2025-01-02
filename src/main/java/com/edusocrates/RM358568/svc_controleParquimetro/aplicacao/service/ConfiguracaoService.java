package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.ConfiguracaoDTO;

public interface ConfiguracaoService {

    ConfiguracaoDTO criarConfiguracao(ConfiguracaoDTO configuracaoDTO);

    ConfiguracaoDTO obterConfiguracao();

    ConfiguracaoDTO atualizarConfiguracao(Long id, ConfiguracaoDTO configuracaoDTO);

    void deletarConfiguracao(Long id);
}
