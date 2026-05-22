package org.serratec.ong_adocao.controller;

import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.AnimalDTORequest;
import org.serratec.ong_adocao.dto.AnimalDTOResponse;
import org.serratec.ong_adocao.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AnimalDTOResponse>> listarCaracteristicas(){
        return ResponseEntity.ok(animalService.listarAnimais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AnimalDTOResponse> criarAnimal(@Valid @RequestBody AnimalDTORequest animalRequest) {
        return ResponseEntity.status(201).body(animalService.criarAnimal(animalRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> atualizarAnimal
            (@PathVariable Long id, @Valid @RequestBody AnimalDTORequest animalRequest) {
        return ResponseEntity.ok(animalService.atualizarAnimal(id, animalRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
