package com.zupedu.bancodigital.cadastrarProposta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private Endereco endereco;

    public Proposta(String nomeCompleto, String cpf, String email, Endereco endereco) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
}
