package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.VeiculoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VeiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/entrada")
    public ResponseEntity<VeiculoDTO> registrarEntrada(@RequestParam String numeroVaga) {
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculoService.registrarEntrada(numeroVaga));
        return ResponseEntity.ok(veiculoDTO);
    }

    @PostMapping("/saida/{id}")
    public ResponseEntity<VeiculoDTO> registrarSaida(@PathVariable Long id) {
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculoService.registrarSaida(id));
        return ResponseEntity.ok(veiculoDTO);
    }
}
