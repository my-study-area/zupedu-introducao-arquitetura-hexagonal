package com.zupedu.livraria.application;

import com.zupedu.livraria.domain.Autor;
import com.zupedu.livraria.domain.DadosNovoAutor;

public class NovoAutorRequest implements DadosNovoAutor {
    private String nome;
    private String email;
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
