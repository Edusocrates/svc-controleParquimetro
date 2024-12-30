package com.edusocrates.RM358568.svc_controleParquimetro.core.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.RegistroEstacionamento;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Tarifa;
import com.edusocrates.RM358568.svc_controleParquimetro.repositorio.RegistroEstacionamentoRepository;
import com.edusocrates.RM358568.svc_controleParquimetro.repositorio.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RegistroEstacionamentoService {

    @Autowired
    private RegistroEstacionamentoRepository registroEstacionamentoRepository;

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<RegistroEstacionamento> listarEstacionadosAtualmente() {
        return registroEstacionamentoRepository.findEstacionadosAtualmente();
    }

    @Transactional
    public RegistroEstacionamento registrarEntrada(RegistroEstacionamento registro) {
        return registroEstacionamentoRepository.save(registro);
    }

    @Transactional
    public RegistroEstacionamento registrarSaida(Long id) {
        RegistroEstacionamento registro = registroEstacionamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Registro não encontrado"));

        if (registro.getHoraSaida() != null) {
            throw new IllegalStateException("A saída já foi registrada para este registro.");
        }

        registro.setHoraSaida(LocalDateTime.now());
        calcularValores(registro);
        return registroEstacionamentoRepository.save(registro);
    }

    private void calcularValores(RegistroEstacionamento registro) {
        Tarifa tarifa = tarifaRepository.findById(1L).orElseThrow(() -> new IllegalStateException("Tarifa não configurada."));
        long minutosEstacionados = ChronoUnit.MINUTES.between(registro.getHoraEntrada(), registro.getHoraSaida());
        registro.setValorPago(minutosEstacionados * tarifa.getValorPorMinuto());
    }
}
