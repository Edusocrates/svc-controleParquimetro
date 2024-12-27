package com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO;

public record ConfiguracaoDTO(
        Long id,
        Integer capacidadeTotal,
        String horarioFuncionamentoInicio,
        String horarioFuncionamentoFim,
        Double tempoMaximoPermissao
) {}
