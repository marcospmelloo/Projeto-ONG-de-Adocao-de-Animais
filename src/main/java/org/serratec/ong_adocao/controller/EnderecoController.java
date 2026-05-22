package org.serratec.ong_adocao.controller;

import jakarta.validation.Valid;
import org.serratec.ong_adocao.dto.EnderecoDTORequest;
import org.serratec.ong_adocao.dto.EnderecoDTOResponse;
import org.serratec.ong_adocao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTOResponse>> listarEnderecos(){
        return ResponseEntity.ok(enderecoService.listarEndereco());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTOResponse> criarEndereco(@Valid @RequestBody EnderecoDTORequest enderecoRequest) {
        return ResponseEntity.status(201).body(enderecoService.criarEndereco(enderecoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco
            (@PathVariable Long id, @Valid @RequestBody EnderecoDTORequest enderecoRequest) {
        return ResponseEntity.ok(enderecoService.atualizarEndereco(id, enderecoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
