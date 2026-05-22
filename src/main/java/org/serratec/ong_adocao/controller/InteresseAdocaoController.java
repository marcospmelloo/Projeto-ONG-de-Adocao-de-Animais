package org.serratec.ong_adocao.controller;

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

@RestController
@RequestMapping("/interesses")
public class InteresseAdocaoController {

    @Autowired
    private InteresseAdocaoService interesseService;

    @GetMapping
    public ResponseEntity<List<InteresseAdocaoDTOResponse>> listarInteresses(){
        return ResponseEntity.ok(interesseService.listarInteresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteresseAdocaoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(interesseService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<InteresseAdocaoDTOResponse> criarInteresse(@Valid @RequestBody InteresseAdocaoDTORequest interesseRequest) {
        return ResponseEntity.status(201).body(interesseService.criarInteresse(interesseRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InteresseAdocaoDTOResponse> atualizarInteresse
            (@PathVariable Long id, @Valid @RequestBody InteresseAdocaoDTORequest interesseRequest) {
        return ResponseEntity.ok(interesseService.atualizarInteresse(id, interesseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarInteresse(@PathVariable Long id) {
        interesseService.deletarInteresse(id);
        return ResponseEntity.noContent().build();
    }
}
