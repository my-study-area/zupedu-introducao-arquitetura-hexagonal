package com.zupedu.bancodigital.cadastrarProposta;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;

    public Endereco(String cep, String logradouro, String numero) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
