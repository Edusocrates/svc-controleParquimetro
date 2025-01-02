package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.impl;

import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.ConfiguracaoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Configuracao;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.ConfiguracaoDTO;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.ConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfiguracaoServiceImpl implements ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    @Transactional
    @Override
    public ConfiguracaoDTO criarConfiguracao(ConfiguracaoDTO configuracaoDTO) {
        Configuracao configuracao = new Configuracao(
                configuracaoDTO.id(),
                configuracaoDTO.horaInicioFuncionamento(),
                configuracaoDTO.horaFimFuncionamento(),
                configuracaoDTO.limiteCapacidade(),
                configuracaoDTO.valorMulta(),
                configuracaoDTO.tempoMaximoPermanencia()
        );

        Configuracao configuracaoSalva = configuracaoRepository.save(configuracao);
        return toDTO(configuracaoSalva);
    }

    @Transactional(readOnly = true)
    @Override
    public ConfiguracaoDTO obterConfiguracao() {
        return configuracaoRepository.findTopByOrderByIdAsc()
                .map(this::toDTO)
                .orElse(null);
    }

    @Transactional
    @Override
    public ConfiguracaoDTO atualizarConfiguracao(Long id, ConfiguracaoDTO configuracaoDTO) {
        Configuracao configuracao = configuracaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Configuração não encontrada com o ID: " + id));

        configuracao.setHoraInicioFuncionamento(configuracaoDTO.horaInicioFuncionamento());
        configuracao.setHoraFimFuncionamento(configuracaoDTO.horaFimFuncionamento());
        configuracao.setLimiteCapacidade(configuracaoDTO.limiteCapacidade());
        configuracao.setValorMulta(configuracaoDTO.valorMulta());
        configuracao.setTempoMaximoPermanencia(configuracaoDTO.tempoMaximoPermanencia());

        Configuracao configuracaoAtualizada = configuracaoRepository.save(configuracao);
        return toDTO(configuracaoAtualizada);
    }

    @Transactional
    @Override
    public void deletarConfiguracao(Long id) {
        Configuracao configuracao = configuracaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Configuração não encontrada com o ID: " + id));

        configuracaoRepository.delete(configuracao);
    }

    private ConfiguracaoDTO toDTO(Configuracao configuracao) {
        return new ConfiguracaoDTO(
                configuracao.getId(),
                configuracao.getHoraInicioFuncionamento(),
                configuracao.getHoraFimFuncionamento(),
                configuracao.getLimiteCapacidade(),
                configuracao.getValorMulta(),
                configuracao.getTempoMaximoPermanencia()
        );
    }
}
