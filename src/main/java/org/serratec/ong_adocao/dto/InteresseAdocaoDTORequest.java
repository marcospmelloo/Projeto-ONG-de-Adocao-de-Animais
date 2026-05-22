package org.serratec.ong_adocao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.serratec.ong_adocao.domain.enumerations.StatusInteresse;

public class InteresseAdocaoDTORequest {

    @NotNull(message = "Deve conter o status de interesse.")
    private StatusInteresse interesse;

    @Size(max = 250, message = "A observação deve conter no máximo 250 caracteres.")
    private String observacao;

    @NotNull(message = "Deve conter o id da pessoa.")
    private Long idPessoa;

    @NotNull(message = "Deve conter o id do animal.")
    private Long idAnimal;

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

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
}
