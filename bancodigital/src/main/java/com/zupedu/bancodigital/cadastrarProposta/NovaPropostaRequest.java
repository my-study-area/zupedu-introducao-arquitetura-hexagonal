package com.zupedu.bancodigital.cadastrarProposta;

public class NovaPropostaRequest {

    private Endereco endereco;
    private String nomeCompleto;
    private String cpf;
    private String email;

    public Proposta toModel() {
        return new Proposta(nomeCompleto, cpf, email, endereco);
    }
}
