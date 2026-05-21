package org.serratec.ong_adocao.exception;

import java.time.LocalDateTime;

public class ErroResposta {

    private int status;
    private String mensagem;

    public ErroResposta(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
