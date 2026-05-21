package org.serratec.ong_adocao.dto;

public class CaracteristicaDTOResponse {

    private Long id;

    private String comportamento;

    private String historico;

    private String observacao;

    public CaracteristicaDTOResponse() {
    }

    public CaracteristicaDTOResponse(Long id, String comportamento, String historico, String observacao) {
        this.id = id;
        this.comportamento = comportamento;
        this.historico = historico;
        this.observacao = observacao;
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
