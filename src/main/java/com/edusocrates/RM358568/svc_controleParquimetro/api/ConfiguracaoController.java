package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.ConfiguracaoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.ConfiguracaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracoes")
@Tag(name = "Configurações estacionamento", description = "Operações relacionadas as configurações e funcionamento do estacionamento")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configuracaoService;


    @PostMapping
    @Operation(summary = "Criar configuração de estacionamento", description = "Criar configuração de estacionamento")
    public ResponseEntity<ConfiguracaoDTO> criarConfiguracao(@RequestBody ConfiguracaoDTO configuracaoDTO) {
        ConfiguracaoDTO configuracaoCriada = configuracaoService.criarConfiguracao(configuracaoDTO);
        return ResponseEntity.ok(configuracaoCriada);
    }

    @GetMapping
    @Operation(summary = "Consulta configurações de estacionamento", description = "Consulta configurações de estacionamento")
    public ResponseEntity<ConfiguracaoDTO> obterConfiguracao() {
        ConfiguracaoDTO configuracao = configuracaoService.obterConfiguracao();
        if (configuracao == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(configuracao);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza configuração de estacionamento", description = "Atualiza configuração de estacionamento")
    public ResponseEntity<ConfiguracaoDTO> atualizarConfiguracao(
            @PathVariable Long id,
            @RequestBody ConfiguracaoDTO configuracaoDTO) {
        ConfiguracaoDTO configuracaoAtualizada = configuracaoService.atualizarConfiguracao(id, configuracaoDTO);
        return ResponseEntity.ok(configuracaoAtualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta configuração de estacionamento", description = "Deleta configuração de estacionamento")
    public ResponseEntity<Void> deletarConfiguracao(@PathVariable Long id) {
        configuracaoService.deletarConfiguracao(id);
        return ResponseEntity.noContent().build();
    }
}
