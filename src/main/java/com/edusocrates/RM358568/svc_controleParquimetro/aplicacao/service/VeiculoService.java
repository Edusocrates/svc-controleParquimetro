package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Veiculo;

public interface VeiculoService {

    Veiculo registrarEntrada(String numeroVaga);

    Veiculo registrarSaida(Long veiculoId);
}
