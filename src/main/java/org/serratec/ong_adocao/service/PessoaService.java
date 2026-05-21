package org.serratec.ong_adocao.service;

import org.serratec.ong_adocao.domain.Endereco;
import org.serratec.ong_adocao.domain.Pessoa;
import org.serratec.ong_adocao.dto.EnderecoDTOResponse;
import org.serratec.ong_adocao.dto.PessoaDTORequest;
import org.serratec.ong_adocao.dto.PessoaDTOResponse;
import org.serratec.ong_adocao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTOResponse> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().map(this::toResponse).toList();
    }

    public PessoaDTOResponse buscarPorId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada!"));
        return toResponse(pessoa);
    }

    public PessoaDTOResponse criarPessoa(PessoaDTORequest pessoaRequest) {
        if(pessoaRepository.existsByCpf(pessoaRequest.getCpf())) {
            throw new DuplicateEntryException("CPF já cadastrado!");
        }

        if(pessoaRepository.existsByEmail(pessoaRequest.getEmail())) {
            throw new DuplicateEntryException("Email já cadastrado!");
        }

        Pessoa pessoa = toEntity(pessoaRequest);
        Pessoa salvo = pessoaRepository.save(pessoa);
        return toResponse(salvo);
    }

    public PessoaDTOResponse atualizarPessoa(Long id, PessoaDTORequest pessoaRequest
    ) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada!"));

        if(!pessoa.getCpf().equals(pessoaRequest.getCpf()) && pessoaRepository.existsByCpf(pessoaRequest.getCpf())) {
            throw new DuplicateEntryException("CPF já cadastrado!");
        }

        if(!pessoa.getEmail().equals(pessoaRequest.getEmail()) && pessoaRepository.existsByEmail(pessoaRequest.getEmail())) {
            throw new DuplicateEntryException("Email já cadastrado!");
        }

        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setCpf(pessoaRequest.getCpf());
        pessoa.setEmail(pessoaRequest.getEmail());
        pessoa.setTelefone(pessoaRequest.getTelefone());
        pessoa.setDataNascimento(pessoaRequest.getDataNascimento());
        pessoaRepository.save(pessoa);
        return toResponse(pessoa);
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada!"));
        pessoaRepository.delete(pessoa);
    }

    private Pessoa toEntity(PessoaDTORequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setCpf(pessoaRequest.getCpf());
        pessoa.setEmail(pessoaRequest.getEmail());
        pessoa.setTelefone(pessoaRequest.getTelefone());
        pessoa.setDataNascimento(pessoaRequest.getDataNascimento());
        return pessoa;
    }

    private PessoaDTOResponse toResponse(Pessoa pessoa) {
        PessoaDTOResponse pessoaResponse = new PessoaDTOResponse();
        pessoaResponse.setId(pessoa.getId());
        pessoaResponse.setNome(pessoa.getNome());
        pessoaResponse.setCpf(pessoa.getCpf());
        pessoaResponse.setEmail(pessoa.getEmail());
        pessoaResponse.setTelefone(pessoa.getTelefone());
        pessoaResponse.setDataNascimento(pessoa.getDataNascimento());

        if(pessoa.getEndereco() != null) {
            pessoaResponse.setEndereco(toEnderecoResponse(pessoa.getEndereco()));
        }
        return pessoaResponse;
    }

    private EnderecoDTOResponse toEnderecoResponse(Endereco endereco) {

        EnderecoDTOResponse enderecoResponse = new EnderecoDTOResponse();
        enderecoResponse.setId(endereco.getId());
        enderecoResponse.setLogradouro(endereco.getLogradouro());
        enderecoResponse.setBairro(endereco.getBairro());
        enderecoResponse.setCidade(endereco.getCidade());
        enderecoResponse.setEstado(endereco.getEstado());
        enderecoResponse.setCep(endereco.getCep());
        return enderecoResponse;
    }
}
