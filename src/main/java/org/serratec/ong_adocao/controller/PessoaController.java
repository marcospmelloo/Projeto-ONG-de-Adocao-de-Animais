package org.serratec.ong_adocao.controller;

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

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTOResponse>> listarPessoas(){
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PessoaDTOResponse> criarPessoa(@Valid @RequestBody PessoaDTORequest pessoaRequest) {
        return ResponseEntity.status(201).body(pessoaService.criarPessoa(pessoaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> atualizarPessoa
            (@PathVariable Long id, @Valid @RequestBody PessoaDTORequest pessoaRequest) {
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, pessoaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
