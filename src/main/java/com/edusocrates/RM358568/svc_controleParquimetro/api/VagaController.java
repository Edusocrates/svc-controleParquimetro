package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.VagaService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VagaDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@Tag(name = "Controle vagas", description = "Controle vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    @Tag(name = "Endpoint para criar Vaga", description = "Endpoint para criar Vaga")
    public ResponseEntity<VagaDTO> criarVaga(@RequestBody VagaDTO vagaDTO) {
        VagaDTO vagaCriada = vagaService.criarVaga(vagaDTO);
        return new ResponseEntity<>(vagaCriada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Tag(name = "Endpoint para atualizar Vaga", description = "Endpoint para atualizar Vaga")
    public ResponseEntity<VagaDTO> atualizarVaga(@PathVariable Long id, @RequestBody VagaDTO vagaDTO) {
        VagaDTO vagaAtualizada = vagaService.atualizarVaga(id, vagaDTO);
        return ResponseEntity.ok(vagaAtualizada);
    }

    @GetMapping
    @Tag(name = "Endpoint para listar vagas", description = "Endpoint para listar vagas")
    public ResponseEntity<List<VagaDTO>> listarVagas() {
        List<VagaDTO> vagas = vagaService.listarVagas();
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/{id}")
    @Tag(name = "Endpoint para consultar vaga", description = "Endpoint para consultar vaga")
    public ResponseEntity<VagaDTO> buscarVagaPorId(@PathVariable Long id) {
        VagaDTO vaga = vagaService.buscarVagaPorId(id);
        return ResponseEntity.ok(vaga);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Endpoint para remover vaga", description = "Endpoint para remover vaga")
    public ResponseEntity<Void> deletarVaga(@PathVariable Long id) {
        vagaService.deletarVaga(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/ocupacao")
    @Tag(name = "Endpoint para atualizar ocupação vaga", description = "Endpoint para atualizar ocupação vaga")
    public ResponseEntity<VagaDTO> atualizarOcupacao(@PathVariable Long id, @RequestBody boolean ocupada) {
        VagaDTO vagaAtualizada = vagaService.atualizarOcupacao(id, ocupada);
        return ResponseEntity.ok(vagaAtualizada);
    }
}

