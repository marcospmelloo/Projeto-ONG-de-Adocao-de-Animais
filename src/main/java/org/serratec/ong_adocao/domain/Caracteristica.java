package org.serratec.ong_adocao.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "caracteristica")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caracteristica")
    private Long id;

    private String comportamento;

    private String historico;

    private String observacao;

    @ManyToMany @JoinTable(name = "animal_caracteristica",
    joinColumns = @JoinColumn(name = "id_caracteristica"),
    inverseJoinColumns = @JoinColumn(name = "id_animal"))
    private List<Animal> animal;

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
