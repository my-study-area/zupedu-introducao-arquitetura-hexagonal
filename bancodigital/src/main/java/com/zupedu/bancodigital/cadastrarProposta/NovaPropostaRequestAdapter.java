package com.zupedu.bancodigital.cadastrarProposta;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovaPropostaRequestAdapter implements NovaPropostaInputPort {
    @NotBlank
    private String nomeCompleto;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    private String complemento;

    public NovaPropostaRequestAdapter(@NotBlank String nomeCompleto,
                                      @NotBlank @CPF String cpf,
                                      @NotBlank @Email String email,
                                      @NotBlank String cep,
                                      @NotBlank String logradouro,
                                      @NotBlank String numero,
                                      String complemento) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public Proposta toModel() {
        var endereco = new Endereco(cep, logradouro, numero, complemento);
        return new Proposta(nomeCompleto, cpf, email, endereco);
    }
}
