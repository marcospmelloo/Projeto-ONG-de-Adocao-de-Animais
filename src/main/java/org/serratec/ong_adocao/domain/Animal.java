package org.serratec.ong_adocao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.serratec.ong_adocao.domain.enumerations.Especie;
import org.serratec.ong_adocao.domain.enumerations.Porte;
import org.serratec.ong_adocao.domain.enumerations.Sexo;
import org.serratec.ong_adocao.domain.enumerations.StatusAnimal;

import java.util.List;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long id;

    private String nome;

    private Especie especie;

    private Porte porte;

    private String raca;

    private Integer idade;

    private Sexo sexo;

    private StatusAnimal statusAnimal;

    private Boolean vacinado;

    private String observacao;

    @OneToMany(mappedBy = "animal")
    @JsonBackReference
    private List<InteresseAdocao> interesseAdocao;

    @ManyToMany @JoinTable(name = "animal_caracteristica",
    joinColumns = @JoinColumn(name = "id_animal"),
    inverseJoinColumns = @JoinColumn(name = "id_caracteristica"))
    @JsonManagedReference
    private List<Caracteristica> caracteristicas;;

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<InteresseAdocao> getInteresseAdocao() {
        return interesseAdocao;
    }

    public void setInteresseAdocao(List<InteresseAdocao> interesseAdocao) {
        this.interesseAdocao = interesseAdocao;
    }
}
