package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.MultaDTO;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Multa;
import com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio.MultaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/multas")
@Tag(name = "Controle Multas", description = "Operações relacionadas as multas")
public class MultaController {

    @Autowired
    private MultaRepository multaRepository;

    @GetMapping("/veiculo/{veiculoId}")
    @Operation(summary = "Endpoint para consultar as multas de um veículo específico", description = "Endpoint para consultar as multas de um veículo específico")
    public ResponseEntity<List<MultaDTO>> consultarMultasPorVeiculo(@PathVariable Long veiculoId) {
        List<Multa> multas = multaRepository.findByVeiculoId(veiculoId);
        List<MultaDTO> multaDTOs = multas.stream().map(MultaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(multaDTOs);
    }
}
