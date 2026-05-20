package org.serratec.ong_adocao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CaracteristicaDTORequest {

    @NotBlank(message = "O comportamento não deve estar vazio.")
    private String comportamento;

    @NotBlank(message = "O histórico não deve estar vazio.")
    @Size(max = 250, message = "O histórico deve ser relatdo em menos de 250 caracteres.")
    private String historico;

    @Size(max = 100, message = "Deve conter menos de 100 caracteres.")
    private String observacao;

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
