package org.serratec.ong_adocao.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.serratec.ong_adocao.domain.enumerations.StatusInteresse;

@Entity
@Table(name = "interesse_adocao")
public class InteresseAdocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interesse_adocao")
    private Long id;

    private StatusInteresse interesse;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    @JsonManagedReference
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusInteresse getInteresse() {
        return interesse;
    }

    public void setInteresse(StatusInteresse interesse) {
        this.interesse = interesse;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
