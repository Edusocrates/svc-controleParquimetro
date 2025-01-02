package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.EstacionamentoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VeiculoDTO;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Veiculo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estacionamento")
@Tag(name = "Controle estacionamento", description = "Operações relacionadas ao funcionamento do estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @PostMapping("/entrada/{vagaId}")
    @Operation(summary = "Endpoint para registrar a entrada do veículo", description = "Endpoint para registrar a entrada do veículo")
    public ResponseEntity<VeiculoDTO> registrarEntrada(@PathVariable Long vagaId) {
        Veiculo veiculo = estacionamentoService.registrarEntrada(vagaId);
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculo);
        return new ResponseEntity<>(veiculoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/saida/{veiculoId}")
    @Operation(summary = "Endpoint para registrar a saída do veículo", description = "Endpoint para registrar a saída do veículo")
    public ResponseEntity<VeiculoDTO> registrarSaida(@PathVariable Long veiculoId) throws ChangeSetPersister.NotFoundException {
        Veiculo veiculo = estacionamentoService.registrarSaida(veiculoId);
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculo);
        return new ResponseEntity<>(veiculoDTO, HttpStatus.OK);
    }

    @GetMapping("/capacidade")
    @Operation(summary = "Endpoint para verificar a capacidade do estacionamento", description = "Endpoint para verificar a capacidade do estacionamento")
    public ResponseEntity<String> verificarCapacidade() throws ChangeSetPersister.NotFoundException {
        boolean estacionamentoCheio = estacionamentoService.isEstacionamentoCheio();
        if (estacionamentoCheio) {
            return new ResponseEntity<>("O estacionamento está cheio.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Existem vagas disponíveis.", HttpStatus.OK);
        }
    }
}
