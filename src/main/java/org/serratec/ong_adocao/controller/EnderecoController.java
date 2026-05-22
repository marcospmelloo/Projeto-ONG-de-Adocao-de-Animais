package org.serratec.ong_adocao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.EnderecoDTORequest;
import org.serratec.ong_adocao.dto.EnderecoDTOResponse;
import org.serratec.ong_adocao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Endereço", description = "Cadastro de endereços")
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Listar todos os endereços", description = "Retorna uma lista com todos os endereços cadastrados")
    @GetMapping
    public ResponseEntity<List<EnderecoDTOResponse>> listarEnderecos(){
        return ResponseEntity.ok(enderecoService.listarEndereco());
    }


    @Operation(summary = "Buscar endereço por ID", description = "Retorna um endereço específico pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar endereço", description = "Cadastra um novo endereço no sistema")
    @PostMapping
    public ResponseEntity<EnderecoDTOResponse> criarEndereco(@Valid @RequestBody EnderecoDTORequest enderecoRequest) {
        return ResponseEntity.status(201).body(enderecoService.criarEndereco(enderecoRequest));
    }

    @Operation(summary = "Atualizar endereço", description = "Atualiza os dados de um endereço existente")
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco
            (@PathVariable Long id, @Valid @RequestBody EnderecoDTORequest enderecoRequest) {
        return ResponseEntity.ok(enderecoService.atualizarEndereco(id, enderecoRequest));
    }

    @Operation(summary = "Deletar endereço", description = "Remove um endereço do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
