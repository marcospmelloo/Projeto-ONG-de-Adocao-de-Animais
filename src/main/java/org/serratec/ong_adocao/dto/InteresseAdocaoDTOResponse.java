package org.serratec.ong_adocao.dto;

import org.serratec.ong_adocao.domain.enumerations.StatusInteresse;

public class InteresseAdocaoDTOResponse {

    private Long id;

    private StatusInteresse interesse;

    private String observacao;

    private Long idPessoa;

    private String nomePessoa;

    private Long idAnimal;

    private String nomeAnimal;

    public InteresseAdocaoDTOResponse() {
    }

    public InteresseAdocaoDTOResponse(Long id, StatusInteresse interesse, String observacao, Long idPessoa,
                                      String nomePessoa, Long idAnimal, String nomeAnimal) {
        this.id = id;
        this.interesse = interesse;
        this.observacao = observacao;
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.idAnimal = idAnimal;
        this.nomeAnimal = nomeAnimal;
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

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }
}
