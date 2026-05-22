package org.serratec.ong_adocao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pessoas retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<PessoaDTOResponse>> listarPessoas(){
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @Operation(summary = "Buscar pessoa por ID", description = "Retorna uma pessoa específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar pessoa", description = "Cadastra uma nova pessoa no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PostMapping
    public ResponseEntity<PessoaDTOResponse> criarPessoa(@Valid @RequestBody PessoaDTORequest pessoaRequest) {
        return ResponseEntity.status(201).body(pessoaService.criarPessoa(pessoaRequest));
    }

    @Operation(summary = "Atualizar pessoa", description = "Atualiza os dados de uma pessoa existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> atualizarPessoa
            (@PathVariable Long id, @Valid @RequestBody PessoaDTORequest pessoaRequest) {
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, pessoaRequest));
    }

    @Operation(summary = "Deletar pessoa", description = "Remove uma pessoa do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pessoa removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
