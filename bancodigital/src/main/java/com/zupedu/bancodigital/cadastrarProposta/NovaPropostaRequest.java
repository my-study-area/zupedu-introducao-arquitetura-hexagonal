package com.zupedu.bancodigital.cadastrarProposta;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaPropostaRequest {
    @NotNull
    private @Valid Endereco endereco = new Endereco();

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    public NovaPropostaRequest(@NotNull @Valid Endereco endereco,
                               @NotBlank String nomeCompleto,
                               @NotBlank @CPF String cpf,
                               @NotBlank @Email String email) {
        this.endereco = endereco;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Proposta toModel() {
        return new Proposta(nomeCompleto, cpf, email, endereco);
    }
}
