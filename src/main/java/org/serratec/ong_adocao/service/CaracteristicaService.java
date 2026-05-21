package org.serratec.ong_adocao.service;

import org.serratec.ong_adocao.domain.Animal;
import org.serratec.ong_adocao.domain.Caracteristica;
import org.serratec.ong_adocao.dto.AnimalDTORequest;
import org.serratec.ong_adocao.dto.AnimalDTOResponse;
import org.serratec.ong_adocao.dto.CaracteristicaDTORequest;
import org.serratec.ong_adocao.dto.CaracteristicaDTOResponse;
import org.serratec.ong_adocao.exception.ResourceNotFoundException;
import org.serratec.ong_adocao.repository.AnimalRepository;
import org.serratec.ong_adocao.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaService {

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    public List<CaracteristicaDTOResponse> listarCaracteristicas() {
        List<Caracteristica> caracateristicas = caracteristicaRepository.findAll();
        return caracateristicas.stream().map(this::toResponse).toList();
    }

    public CaracteristicaDTOResponse buscarPorId(Long id) {
        Caracteristica caracteristica = caracteristicaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id do animal não encontrado"));
        return toResponse(caracteristica);
    }

    public CaracteristicaDTOResponse criarCaracteristica(CaracteristicaDTORequest caracteristicaRequest) {
        Caracteristica caracteristica = toEntity(caracteristicaRequest);
        Caracteristica salvo = caracteristicaRepository.save(caracteristica);
        return toResponse(salvo);
    }

    public CaracteristicaDTOResponse atualizarCaracteristica(Long id, CaracteristicaDTORequest caracteristicaRequest) {
        Caracteristica caracteristica = caracteristicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Caracteristica não foi encontrada!"));
        caracteristica.setHistorico(caracteristicaRequest.getHistorico());
        caracteristica.setComportamento(caracteristicaRequest.getComportamento());
        caracteristica.setObservacao(caracteristicaRequest.getObservacao());
        Caracteristica salvo = caracteristicaRepository.save(caracteristica);
        return toResponse(salvo);
    }

    public void deletarCaracteristica(Long id) {
        Caracteristica caracteristica = caracteristicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Caracteristica não foi ecnotrada!"));
        caracteristicaRepository.delete(caracteristica);
    }

    private Caracteristica toEntity(CaracteristicaDTORequest caracteristicaRequest) {
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setHistorico(caracteristicaRequest.getHistorico());
        caracteristica.setComportamento(caracteristicaRequest.getComportamento());
        caracteristica.setObservacao(caracteristicaRequest.getObservacao());
        return caracteristica;
    }

    private CaracteristicaDTOResponse toResponse(Caracteristica caracteristica) {
        CaracteristicaDTOResponse caracteristicaResponse = new CaracteristicaDTOResponse();
        caracteristicaResponse.setId(caracteristica.getId());
        caracteristicaResponse.setHistorico(caracteristica.getHistorico());
        caracteristicaResponse.setComportamento(caracteristica.getComportamento());
        caracteristicaResponse.setObservacao(caracteristica.getObservacao());
        return caracteristicaResponse;
    }
}
