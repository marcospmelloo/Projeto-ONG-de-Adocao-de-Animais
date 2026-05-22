package org.serratec.ong_adocao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.CaracteristicaDTORequest;
import org.serratec.ong_adocao.dto.CaracteristicaDTOResponse;
import org.serratec.ong_adocao.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Caracteristica", description = "Cadastro de características")
@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @Operation(summary = "Listar todos as características", description = "Retorna uma lista com todos as características cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de características retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<CaracteristicaDTOResponse>> listarCaracteristicas(){
        return ResponseEntity.ok(caracteristicaService.listarCaracteristicas());
    }

    @Operation(summary = "Buscar característica por ID", description = "Retorna uma característica específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Característica encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Característica não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(caracteristicaService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar característica", description = "Cadastra uma nova característica no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Caracteristica cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PostMapping
    public ResponseEntity<CaracteristicaDTOResponse> criarCaracteristica(@Valid @RequestBody CaracteristicaDTORequest caracteristicaRequest) {
        return ResponseEntity.status(201).body(caracteristicaService.criarCaracteristica(caracteristicaRequest));
    }

    @Operation(summary = "Atualizar característica", description = "Atualiza os dados de uma característica existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Caracteristica atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Caracteristica não encontrada"),
            @ApiResponse(responseCode = "409", description = "Conflito de dados")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CaracteristicaDTOResponse> atualizarCaracteristica
            (@PathVariable Long id, @Valid @RequestBody CaracteristicaDTORequest caracteristicaRequest) {
        return ResponseEntity.ok(caracteristicaService.atualizarCaracteristica(id, caracteristicaRequest));
    }

    @Operation(summary = "Deletar característica", description = "Remove uma característica do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Característica removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Característica não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaracteristica(@PathVariable Long id) {
        caracteristicaService.deletarCaracteristica(id);
        return ResponseEntity.noContent().build();
    }
}
