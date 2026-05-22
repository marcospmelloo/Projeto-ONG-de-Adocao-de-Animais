package org.serratec.ong_adocao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CaracteristicaDTORequest {

    @Schema(description = "Comportamento do animal", example = "Dócil")
    @NotBlank(message = "O comportamento não deve estar vazio.")
    private String comportamento;

    @Schema(description = "Histórico do animal", example = "Resgatado de maus tratos")
    @NotBlank(message = "O histórico não deve estar vazio.")
    @Size(max = 250, message = "O histórico deve ser relatdo em menos de 250 caracteres.")
    private String historico;

    @Schema(description = "Observação do interesse de adoção", example = "Possui quintal grande")
    @Size(max = 100, message = "Deve conter menos de 100 caracteres.")
    private String observacao;

    public CaracteristicaDTORequest() {
    }

    public CaracteristicaDTORequest(String comportamento, String historico, String observacao) {
        this.comportamento = comportamento;
        this.historico = historico;
        this.observacao = observacao;
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
