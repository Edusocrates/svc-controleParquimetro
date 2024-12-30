package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.EstacionamentoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.VeiculoDTO;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    // Endpoint para registrar a entrada do veículo
    @PostMapping("/entrada/{vagaId}")
    public ResponseEntity<VeiculoDTO> registrarEntrada(@PathVariable Long vagaId) {
        Veiculo veiculo = estacionamentoService.registrarEntrada(vagaId);
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculo);
        return new ResponseEntity<>(veiculoDTO, HttpStatus.CREATED);
    }

    // Endpoint para registrar a saída do veículo
    @PostMapping("/saida/{veiculoId}")
    public ResponseEntity<VeiculoDTO> registrarSaida(@PathVariable Long veiculoId) throws ChangeSetPersister.NotFoundException {
        Veiculo veiculo = estacionamentoService.registrarSaida(veiculoId);
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculo);
        return new ResponseEntity<>(veiculoDTO, HttpStatus.OK);
    }

    // Endpoint para verificar a capacidade do estacionamento
    @GetMapping("/capacidade")
    public ResponseEntity<String> verificarCapacidade() throws ChangeSetPersister.NotFoundException {
        boolean estacionamentoCheio = estacionamentoService.isEstacionamentoCheio();
        if (estacionamentoCheio) {
            return new ResponseEntity<>("O estacionamento está cheio.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Existem vagas disponíveis.", HttpStatus.OK);
        }
    }
}
