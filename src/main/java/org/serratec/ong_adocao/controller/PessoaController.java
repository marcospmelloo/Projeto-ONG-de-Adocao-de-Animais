package org.serratec.ong_adocao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.AnimalDTORequest;
import org.serratec.ong_adocao.dto.AnimalDTOResponse;
import org.serratec.ong_adocao.dto.PessoaDTORequest;
import org.serratec.ong_adocao.dto.PessoaDTOResponse;
import org.serratec.ong_adocao.service.AnimalService;
import org.serratec.ong_adocao.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pessoa", description = "Cadastro de Pessoas")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista com todas as pessoas cadastradas")
    @GetMapping
    public ResponseEntity<List<PessoaDTOResponse>> listarPessoas(){
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @Operation(summary = "Buscar pessoa por ID", description = "Retorna uma pessoa específica pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar pessoa", description = "Cadastra uma nova pessoa no sistema")
    @PostMapping
    public ResponseEntity<PessoaDTOResponse> criarPessoa(@Valid @RequestBody PessoaDTORequest pessoaRequest) {
        return ResponseEntity.status(201).body(pessoaService.criarPessoa(pessoaRequest));
    }

    @Operation(summary = "Atualizar pessoa", description = "Atualiza os dados de uma pessoa existente")
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> atualizarPessoa
            (@PathVariable Long id, @Valid @RequestBody PessoaDTORequest pessoaRequest) {
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, pessoaRequest));
    }

    @Operation(summary = "Deletar pessoa", description = "Remove uma pessoa do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
