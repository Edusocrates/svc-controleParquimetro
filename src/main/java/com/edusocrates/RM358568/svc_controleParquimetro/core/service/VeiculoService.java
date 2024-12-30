package com.edusocrates.RM358568.svc_controleParquimetro.core.service;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Veiculo;
import com.edusocrates.RM358568.svc_controleParquimetro.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo registrarVeiculo(Veiculo veiculo) {
        if (veiculoRepository.existsByPlaca(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Veículo com essa placa já está registrado.");
        }
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }
}
