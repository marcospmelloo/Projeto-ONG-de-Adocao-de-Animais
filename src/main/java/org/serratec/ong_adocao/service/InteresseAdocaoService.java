package org.serratec.ong_adocao.service;

import org.serratec.ong_adocao.domain.Animal;
import org.serratec.ong_adocao.domain.InteresseAdocao;
import org.serratec.ong_adocao.domain.Pessoa;
import org.serratec.ong_adocao.dto.InteresseAdocaoDTORequest;
import org.serratec.ong_adocao.dto.InteresseAdocaoDTOResponse;
import org.serratec.ong_adocao.exception.DuplicateEntryException;
import org.serratec.ong_adocao.exception.ResourceNotFoundException;
import org.serratec.ong_adocao.repository.AnimalRepository;
import org.serratec.ong_adocao.repository.InteresseAdocaoRepository;
import org.serratec.ong_adocao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresseAdocaoService {

    @Autowired
    private InteresseAdocaoRepository interesseAdocaoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public List<InteresseAdocaoDTOResponse> listarInteresses() {
        List<InteresseAdocao> interesses = interesseAdocaoRepository.findAll();
        return interesses.stream().map(this::toResponse).toList();
    }

    public InteresseAdocaoDTOResponse buscarPorId(Long id) {
        InteresseAdocao interesse = interesseAdocaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interesse de adoção não encontrado!"));
        return toResponse(interesse);
    }

    public InteresseAdocaoDTOResponse criarInteresse(InteresseAdocaoDTORequest interesseRequest) {
        Pessoa pessoa = pessoaRepository.findById(interesseRequest.getIdPessoa()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada!"));
        Animal animal = animalRepository.findById(interesseRequest.getIdAnimal()).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado!"));

        if(interesseAdocaoRepository.existsByPessoaIdAndAnimalId(interesseRequest.getIdPessoa(), interesseRequest.getIdAnimal())) {
            throw new DuplicateEntryException("A pessoa já demonstrou interesse nesse animal!");
        }

        InteresseAdocao interesse = toEntity(interesseRequest, pessoa, animal);
        InteresseAdocao salvo = interesseAdocaoRepository.save(interesse);
        return toResponse(salvo);
    }

    public InteresseAdocaoDTOResponse atualizarInteresse(Long id, InteresseAdocaoDTORequest interesseRequest) {
        InteresseAdocao interesse = interesseAdocaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interesse de adoção não encontrado!"));
        interesse.setInteresse(interesseRequest.getInteresse());
        interesse.setObservacao(interesseRequest.getObservacao());
        interesseAdocaoRepository.save(interesse);
        return toResponse(interesse);
    }

    public void deletarInteresse(Long id) {
        InteresseAdocao interesse = interesseAdocaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interesse de adoção não encontrado!"));
        interesseAdocaoRepository.delete(interesse);
    }

    private InteresseAdocao toEntity(InteresseAdocaoDTORequest interesseRequest, Pessoa pessoa, Animal animal) {
        InteresseAdocao interesse = new InteresseAdocao();
        interesse.setInteresse(interesseRequest.getInteresse());
        interesse.setObservacao(interesseRequest.getObservacao());
        interesse.setPessoa(pessoa);
        interesse.setAnimal(animal);
        return interesse;
    }

    private InteresseAdocaoDTOResponse toResponse(InteresseAdocao interesse) {
        InteresseAdocaoDTOResponse interesseResponse = new InteresseAdocaoDTOResponse();
        interesseResponse.setId(interesse.getId());
        interesseResponse.setInteresse(interesse.getInteresse());
        interesseResponse.setObservacao(interesse.getObservacao());
        interesseResponse.setIdPessoa(interesse.getPessoa().getId());
        interesseResponse.setNomePessoa(interesse.getPessoa().getNome());
        interesseResponse.setIdAnimal(interesse.getAnimal().getId());
        interesseResponse.setNomeAnimal(interesse.getAnimal().getNome());
        return interesseResponse;
    }
}
