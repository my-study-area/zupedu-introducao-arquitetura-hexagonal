package com.zupedu.bancodigital.compartilhada;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MensagemDeErroResponse {
    private Integer status;
    private LocalDateTime data;
    private String descricao;
    private List<CampoComErro> mensagensDeErro = new ArrayList<>();

    public MensagemDeErroResponse(Integer status, LocalDateTime data, String descricao) {
        this.status = status;
        this.data = data;
        this.descricao = descricao;
    }

    public MensagemDeErroResponse(Integer status, LocalDateTime data, String descricao, List<CampoComErro> mensagensDeErro) {
        this.status = status;
        this.data = data;
        this.descricao = descricao;
        this.mensagensDeErro = mensagensDeErro = mensagensDeErro;
    }

    public void adiciona(CampoComErro campo) {
        this.mensagensDeErro.add(campo);
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<CampoComErro> getMensagensDeErro() {
        return mensagensDeErro;
    }
}
