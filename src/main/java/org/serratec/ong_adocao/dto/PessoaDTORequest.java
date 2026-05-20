package org.serratec.ong_adocao.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class PessoaDTORequest {

    @NotBlank(message = "Deve conter o nome.")
    private String nome;

    @NotBlank(message = "Deve conter o cpf.")
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotBlank(message = "Deve conter um email.")
    @Email(message = "Email inválido!")
    private String email;

    @NotBlank(message = "Deve conter um telefone.")
    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 dígitos.")
    private String telefone;

    @NotBlank(message = "Deve conter a data de nascimento.")
    @Past(message = "A data deve estar no passado.")
    private LocalDate dataNascimento;

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
