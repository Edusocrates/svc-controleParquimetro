package com.edusocrates.RM358568.svc_controleParquimetro.core.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.CapacidadeEstacionamento;
import com.edusocrates.RM358568.svc_controleParquimetro.repositorio.CapacidadeEstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CapacidadeEstacionamentoService {

    @Autowired
    private CapacidadeEstacionamentoRepository capacidadeEstacionamentoRepository;

    public Optional<CapacidadeEstacionamento> getCapacidadeAtual() {
        return capacidadeEstacionamentoRepository.findById(1L);
    }

    public void atualizarCapacidade(int alteracao) {
        CapacidadeEstacionamento capacidade = capacidadeEstacionamentoRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("Capacidade não configurada"));

        capacidade.setCapacidadeAtual(capacidade.getCapacidadeAtual() + alteracao);
        capacidadeEstacionamentoRepository.save(capacidade);
    }
}
