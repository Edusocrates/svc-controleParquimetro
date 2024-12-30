package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.VagaService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VagaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public ResponseEntity<VagaDTO> criarVaga(@RequestBody VagaDTO vagaDTO) {
        VagaDTO vagaCriada = vagaService.criarVaga(vagaDTO);
        return new ResponseEntity<>(vagaCriada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDTO> atualizarVaga(@PathVariable Long id, @RequestBody VagaDTO vagaDTO) {
        VagaDTO vagaAtualizada = vagaService.atualizarVaga(id, vagaDTO);
        return ResponseEntity.ok(vagaAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<VagaDTO>> listarVagas() {
        List<VagaDTO> vagas = vagaService.listarVagas();
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDTO> buscarVagaPorId(@PathVariable Long id) {
        VagaDTO vaga = vagaService.buscarVagaPorId(id);
        return ResponseEntity.ok(vaga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Long id) {
        vagaService.deletarVaga(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/ocupacao")
    public ResponseEntity<VagaDTO> atualizarOcupacao(@PathVariable Long id, @RequestBody boolean ocupada) {
        VagaDTO vagaAtualizada = vagaService.atualizarOcupacao(id, ocupada);
        return ResponseEntity.ok(vagaAtualizada);
    }
}

