package com.zupedu.bancodigital.cadastrarProposta;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;
    private String complemento;

    /**
     * Uso exclusivo do framework
     */
    @Deprecated
    public Endereco() { }

    public Endereco(@NotBlank String cep,
                    @NotBlank String logradouro,
                    @NotBlank String numero,
                    String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
