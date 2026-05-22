package org.serratec.ong_adocao.controller;

import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.CaracteristicaDTORequest;
import org.serratec.ong_adocao.dto.CaracteristicaDTOResponse;
import org.serratec.ong_adocao.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @GetMapping
    public ResponseEntity<List<CaracteristicaDTOResponse>> listarCaracteristicas(){
        return ResponseEntity.ok(caracteristicaService.listarCaracteristicas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(caracteristicaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CaracteristicaDTOResponse> criarCaracteristica(@Valid @RequestBody CaracteristicaDTORequest caracteristicaRequest) {
        return ResponseEntity.status(201).body(caracteristicaService.criarCaracteristica(caracteristicaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaracteristicaDTOResponse> atualizarCaracteristica
            (@PathVariable Long id, @Valid @RequestBody CaracteristicaDTORequest caracteristicaRequest) {
        return ResponseEntity.ok(caracteristicaService.atualizarCaracteristica(id, caracteristicaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaracteristica(@PathVariable Long id) {
        caracteristicaService.deletarCaracteristica(id);
        return ResponseEntity.noContent().build();
    }
}
