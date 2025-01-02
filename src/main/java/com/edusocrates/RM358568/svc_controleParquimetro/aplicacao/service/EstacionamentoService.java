package com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Veiculo;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface EstacionamentoService {

    Veiculo registrarEntrada(Long vagaId);

    Veiculo registrarSaida(Long veiculoId) throws ChangeSetPersister.NotFoundException;

    boolean isEstacionamentoCheio() throws ChangeSetPersister.NotFoundException;
}
