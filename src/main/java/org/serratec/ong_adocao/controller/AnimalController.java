package org.serratec.ong_adocao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.AnimalDTORequest;
import org.serratec.ong_adocao.dto.AnimalDTOResponse;
import org.serratec.ong_adocao.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Animal", description = "Cadastro de animais")
@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Operation(summary = "Listar todos os animais", description = "Retorna uma lista com todos os animais cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de animais retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<AnimalDTOResponse>> listarCaracteristicas(){
        return ResponseEntity.ok(animalService.listarAnimais());
    }

    @Operation(summary = "Buscar animal pelo ID", description = "Retorna um animal específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Animal encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Animal não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar animal", description = "Cadastra um novo animal no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Animal cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PostMapping
    public ResponseEntity<AnimalDTOResponse> criarAnimal(@Valid @RequestBody AnimalDTORequest animalRequest) {
        return ResponseEntity.status(201).body(animalService.criarAnimal(animalRequest));
    }

    @Operation(summary = "Atualizar animal", description = "Atualiza os dados de um animal existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Animal atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Animal não encontrado"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> atualizarAnimal
            (@PathVariable Long id, @Valid @RequestBody AnimalDTORequest animalRequest) {
        return ResponseEntity.ok(animalService.atualizarAnimal(id, animalRequest));
    }

    @Operation(summary = "Deletar animal", description = "Remove um animal do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Animal removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Animal não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
