package com.edusocrates.RM358568.svc_controleParquimetro.api;


import com.edusocrates.RM358568.svc_controleParquimetro.aplicacao.service.ConfiguracaoService;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.DTO.ConfiguracaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configuracaoService;


    @PostMapping
    public ResponseEntity<ConfiguracaoDTO> criarConfiguracao(@RequestBody ConfiguracaoDTO configuracaoDTO) {
        ConfiguracaoDTO configuracaoCriada = configuracaoService.criarConfiguracao(configuracaoDTO);
        return ResponseEntity.ok(configuracaoCriada);
    }

    @GetMapping
    public ResponseEntity<ConfiguracaoDTO> obterConfiguracao() {
        ConfiguracaoDTO configuracao = configuracaoService.obterConfiguracao();
        if (configuracao == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(configuracao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracaoDTO> atualizarConfiguracao(
            @PathVariable Long id,
            @RequestBody ConfiguracaoDTO configuracaoDTO) {
        ConfiguracaoDTO configuracaoAtualizada = configuracaoService.atualizarConfiguracao(id, configuracaoDTO);
        return ResponseEntity.ok(configuracaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConfiguracao(@PathVariable Long id) {
        configuracaoService.deletarConfiguracao(id);
        return ResponseEntity.noContent().build();
    }
}
