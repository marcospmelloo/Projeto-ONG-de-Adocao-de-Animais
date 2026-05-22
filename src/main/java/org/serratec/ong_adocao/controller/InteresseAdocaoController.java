package org.serratec.ong_adocao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.AnimalDTORequest;
import org.serratec.ong_adocao.dto.AnimalDTOResponse;
import org.serratec.ong_adocao.dto.InteresseAdocaoDTORequest;
import org.serratec.ong_adocao.dto.InteresseAdocaoDTOResponse;
import org.serratec.ong_adocao.service.AnimalService;
import org.serratec.ong_adocao.service.InteresseAdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Interesse Adoção", description = "Cadastro de interesses de adoção")
@RestController
@RequestMapping("/interesses")
public class InteresseAdocaoController {

    @Autowired
    private InteresseAdocaoService interesseService;

    @Operation(summary = "Listar todos os interesses de adoção", description = "Retorna uma lista com todos os interesses de adoção cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de interesses de adoção retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<InteresseAdocaoDTOResponse>> listarInteresses(){
        return ResponseEntity.ok(interesseService.listarInteresses());
    }

    @Operation(summary = "Buscar interesse de adoção por ID", description = "Retorna um interesse de adoção específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Interesse encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Interesse não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<InteresseAdocaoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(interesseService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar interesse de adoção", description = "Cadastra um novo interesse de adoção no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Interesse cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PostMapping
    public ResponseEntity<InteresseAdocaoDTOResponse> criarInteresse(@Valid @RequestBody InteresseAdocaoDTORequest interesseRequest) {
        return ResponseEntity.status(201).body(interesseService.criarInteresse(interesseRequest));
    }

    @Operation(summary = "Atualizar interesse de adoção", description = "Atualiza os dados de um interesse de adoção existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Interesse atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Interesse não encontrado"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PutMapping("/{id}")
    public ResponseEntity<InteresseAdocaoDTOResponse> atualizarInteresse
            (@PathVariable Long id, @Valid @RequestBody InteresseAdocaoDTORequest interesseRequest) {
        return ResponseEntity.ok(interesseService.atualizarInteresse(id, interesseRequest));
    }

    @Operation(summary = "Deletar interesse de adoção", description = "Remove um interesse de adoção do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Interesse removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Interesse não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarInteresse(@PathVariable Long id) {
        interesseService.deletarInteresse(id);
        return ResponseEntity.noContent().build();
    }
}
