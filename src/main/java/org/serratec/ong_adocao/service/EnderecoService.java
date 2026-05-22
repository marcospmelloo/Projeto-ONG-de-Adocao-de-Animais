package org.serratec.ong_adocao.service;

import org.serratec.ong_adocao.domain.Endereco;
import org.serratec.ong_adocao.domain.Pessoa;
import org.serratec.ong_adocao.dto.EnderecoDTORequest;
import org.serratec.ong_adocao.dto.EnderecoDTOResponse;
import org.serratec.ong_adocao.exception.DuplicateEntryException;
import org.serratec.ong_adocao.exception.ResourceNotFoundException;
import org.serratec.ong_adocao.repository.EnderecoRepository;
import org.serratec.ong_adocao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<EnderecoDTOResponse> listarEndereco() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(this::toResponse).toList();
    }

    public EnderecoDTOResponse buscarPorId(Long id) {
        Endereco enderecos = enderecoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id do endereco não encontrado"));
        return toResponse(enderecos);
    }

    public EnderecoDTOResponse criarEndereco(EnderecoDTORequest enderecoRequest) {
        Pessoa pessoa = pessoaRepository.findById(enderecoRequest.getIdPessoa()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com id"));

        if (enderecoRepository.existsByPessoaId(enderecoRequest.getIdPessoa())) {
            throw new DuplicateEntryException("Pessoa já possui endereço cadastrado");
        }

        Endereco endereco = toEntity(enderecoRequest, pessoa);
        return toResponse(enderecoRepository.save(endereco));
    }

    public EnderecoDTOResponse atualizarEndereco(Long id, EnderecoDTORequest enderecoRequest) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Endereço não foi encontrado!"));
        endereco.setLogradouro(enderecoRequest.getLogradouro());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        endereco.setBairro(enderecoRequest.getBairro());
        endereco.setCidade(enderecoRequest.getCidade());
        endereco.setEstado(enderecoRequest.getEstado());
        endereco.setCep(enderecoRequest.getCep());
        Endereco salvo = enderecoRepository.save(endereco);
        return toResponse(salvo);
    }

    public void deletarEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Endereço não foi encontrado!"));
        enderecoRepository.delete(endereco);
    }

    private Endereco toEntity(EnderecoDTORequest enderecoRequest, Pessoa pessoa) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoRequest.getLogradouro());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        endereco.setBairro(enderecoRequest.getBairro());
        endereco.setCidade(enderecoRequest.getCidade());
        endereco.setEstado(enderecoRequest.getEstado());
        endereco.setCep(enderecoRequest.getCep());
        endereco.setPessoa(pessoa);
        return endereco;
    }

    private EnderecoDTOResponse toResponse(Endereco endereco) {
        EnderecoDTOResponse enderecoResponse = new EnderecoDTOResponse();
        enderecoResponse.setId(endereco.getId());
        enderecoResponse.setLogradouro(endereco.getLogradouro());
        enderecoResponse.setNumero(endereco.getNumero());
        enderecoResponse.setComplemento(endereco.getComplemento());
        enderecoResponse.setBairro(endereco.getBairro());
        enderecoResponse.setCidade(endereco.getCidade());
        enderecoResponse.setEstado(endereco.getEstado());
        enderecoResponse.setCep(endereco.getCep());
        return enderecoResponse;
    }
}
