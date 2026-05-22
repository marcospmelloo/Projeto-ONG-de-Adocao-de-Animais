package org.serratec.ong_adocao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.serratec.ong_adocao.domain.enumerations.Especie;
import org.serratec.ong_adocao.domain.enumerations.Porte;
import org.serratec.ong_adocao.domain.enumerations.Sexo;
import org.serratec.ong_adocao.domain.enumerations.StatusAnimal;

import java.util.List;

public class AnimalDTORequest {

    @NotBlank(message = "O nome não deve estar vazio.")
    private String nome;

    @NotNull(message = "Deve conter uma espécie.")
    private Especie especie;

    @NotNull(message = "Deve conter um tipo de porte.")
    private Porte porte;

    private String raca;

    @NotNull(message = "Deve conter uma idade.")
    @Positive(message = "A idade deve ser um número positivo.")
    private Integer idade;

    @NotNull(message = "Deve conter um sexo.")
    private Sexo sexo;

    @NotNull(message = "O animal deve conter um status.")
    private StatusAnimal statusAnimal;

    @NotNull(message = "É necessário informar se o animal é vacinado ou não.")
    private Boolean vacinado;

    @Size(max = 100, message = "A observação deve conter no máx. 100 caracteres.")
    private String observacao;

    private List<Long> idCaracteristicas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public StatusAnimal getStatusAnimal() {
        return statusAnimal;
    }

    public void setStatusAnimal(StatusAnimal statusAnimal) {
        this.statusAnimal = statusAnimal;
    }

    public Boolean getVacinado() {
        return vacinado;
    }

    public void setVacinado(Boolean vacinado) {
        this.vacinado = vacinado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Long> getIdCaracteristicas() {
        return idCaracteristicas;
    }

    public void setIdCaracteristicas(List<Long> idCaracteristicas) {
        this.idCaracteristicas = idCaracteristicas;
    }
}
