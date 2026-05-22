package org.serratec.ong_adocao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class PessoaDTORequest {

    @Schema(description = "Nome", example = "Marcos")
    @NotBlank(message = "Deve conter o nome.")
    private String nome;

    @Schema(description = "CPF da pessoa", example = "12345678900")
    @NotBlank(message = "Deve conter o cpf.")
    @CPF(message = "CPF inválido!")
    private String cpf;

    @Schema(description = "Email", example = "marcos@gmail.com")
    @NotBlank(message = "Deve conter um email.")
    @Email(message = "Email inválido!")
    private String email;

    @Schema(description = "Telefone", example = "24999999999")
    @NotBlank(message = "Deve conter um telefone.")
    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 dígitos.")
    private String telefone;

    @Schema(description = "Data de nascimento", example = "2005-08-15")
    @NotNull(message = "Deve conter a data de nascimento.")
    @Past(message = "A data deve estar no passado.")
    private LocalDate dataNascimento;

    public PessoaDTORequest() {
    }

    public PessoaDTORequest(String nome, String cpf, String email, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
