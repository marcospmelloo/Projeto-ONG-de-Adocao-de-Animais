package org.serratec.ong_adocao.domain;

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
