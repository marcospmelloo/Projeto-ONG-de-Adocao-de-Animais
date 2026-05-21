package org.serratec.ong_adocao.service;

import org.serratec.ong_adocao.domain.Animal;
import org.serratec.ong_adocao.domain.Caracteristica;
import org.serratec.ong_adocao.dto.AnimalDTORequest;
import org.serratec.ong_adocao.dto.AnimalDTOResponse;
import org.serratec.ong_adocao.repository.AnimalRepository;
import org.serratec.ong_adocao.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    public List<AnimalDTOResponse> listarAnimais() {
        List<Animal> animais = animalRepository.findAll();
        return animais.stream().map(this::toResponse).toList();
    }

    public AnimalDTOResponse buscarPorId(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id do animal não encontrado"));
        return toResponse(animal);
    }

    public AnimalDTOResponse criarAnimal(AnimalDTORequest animalRequest) {
        Animal animal = toEntity(animalRequest);
        Animal salvo = animalRepository.save(animal);
        return toResponse(salvo);
    }

    public AnimalDTOResponse atualizarAnimal(Long id, AnimalDTORequest animalRequest) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O animal não foi encontrado!"));
        animal.setNome(animalRequest.getNome());
        animal.setEspecie(animalRequest.getEspecie());
        animal.setPorte(animalRequest.getPorte());
        animal.setRaca(animalRequest.getRaca());
        animal.setIdade(animalRequest.getIdade());
        animal.setSexo(animalRequest.getSexo());
        animal.setStatusAnimal(animalRequest.getStatusAnimal());
        animal.setVacinado(animalRequest.getVacinado());
        animal.setObservacao(animalRequest.getObservacao());
        List<Caracteristica> caracteristicas = caracteristicaRepository.findAllById(animalRequest.getIdCaracteristicas());
        animal.setCaracteristicas(caracteristicas);
        animalRepository.save(animal);
        return toResponse(animal);
    }

    public void deletarAnimal(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não foi ecnotrado!"));
        animalRepository.delete(animal);
    }

    private Animal toEntity(AnimalDTORequest animalRequest) {
        Animal animal = new Animal();
        animal.setNome(animalRequest.getNome());
        animal.setEspecie(animalRequest.getEspecie());
        animal.setPorte(animalRequest.getPorte());
        animal.setRaca(animalRequest.getRaca());
        animal.setIdade(animalRequest.getIdade());
        animal.setSexo(animalRequest.getSexo());
        animal.setStatusAnimal(animalRequest.getStatusAnimal());
        animal.setVacinado(animalRequest.getVacinado());
        animal.setObservacao(animalRequest.getObservacao());

        if(animalRequest.getIdCaracteristicas() != null) {
            List<Caracteristica> caractersticas = caracteristicaRepository.findAllById(animalRequest.getIdCaracteristicas());
            animal.setCaracteristicas(caractersticas);
        }
        return animal;
    }

    private AnimalDTOResponse toResponse(Animal animal) {
        AnimalDTOResponse animalResponse = new AnimalDTOResponse();
        animalResponse.setNome(animal.getNome());
        animalResponse.setEspecie(animal.getEspecie());
        animalResponse.setPorte(animal.getPorte());
        animalResponse.setRaca(animal.getRaca());
        animalResponse.setIdade(animal.getIdade());
        animalResponse.setSexo(animal.getSexo());
        animalResponse.setStatusAnimal(animal.getStatusAnimal());
        animalResponse.setVacinado(animal.getVacinado());
        animalResponse.setObservacao(animal.getObservacao());

        if(animal.getCaracteristicas() != null) {
            animalResponse.setCaracteristicas(animal.getCaracteristicas().stream().map(Caracteristica::getComportamento).toList());
        }
        return animalResponse;
    }
}
