package org.serratec.ong_adocao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EnderecoDTORequest {

    @NotBlank(message = "Deve conter o logradouro.")
    private String logradouro;

    @NotBlank(message = "Deve conter o número da casa.")
    private String numero;

    private String complemento;

    @NotBlank(message = "Deve conter o bairro.")
    private String bairro;

    @NotBlank(message = "Deve conter a  cidade.")
    private String cidade;

    @NotBlank(message = "Deve conter o estado.")
    @Size(max = 2, min = 2, message = "O estado deve estar em sigla. Ex: RJ")
    private String estado;

    @NotBlank(message = "Deve conter o CEP.")
    private String cep;

    @NotNull(message = "O id da pessoa moradora é obrigatório.")
    private Long idPessoa;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}
