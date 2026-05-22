package org.serratec.ong_adocao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EnderecoDTORequest {

    @Schema(description = "Logradouro", example = "Rua das Flores")
    @NotBlank(message = "Deve conter o logradouro.")
    private String logradouro;

    @Schema(description = "Número do endereço", example = "150")
    @NotBlank(message = "Deve conter o número da casa.")
    private String numero;

    @Schema(description = "Complemento de localização", example = "Em frente à padaria")
    private String complemento;

    @Schema(description = "Bairro", example = "Centro")
    @NotBlank(message = "Deve conter o bairro.")
    private String bairro;

    @Schema(description = "Cidade", example = "Petrópolis")
    @NotBlank(message = "Deve conter a  cidade.")
    private String cidade;

    @Schema(description = "Estado", example = "RJ")
    @NotBlank(message = "Deve conter o estado.")
    @Size(max = 2, min = 2, message = "O estado deve estar em sigla. Ex: RJ")
    private String estado;

    @Schema(description = "CEP", example = "25600000")
    @NotBlank(message = "Deve conter o CEP.")
    private String cep;

    @Schema(description = "Id do morador", example = "1")
    @NotNull(message = "O id da pessoa moradora é obrigatório.")
    private Long idPessoa;

    public EnderecoDTORequest() {
    }

    public EnderecoDTORequest(String logradouro, String numero, String complemento, String bairro,
                              String cidade, String estado, String cep, Long idPessoa) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idPessoa = idPessoa;
    }

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
