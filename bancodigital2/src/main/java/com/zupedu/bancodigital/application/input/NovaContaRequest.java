package com.zupedu.bancodigital.application.input;

import com.zupedu.bancodigital.domain.conta.Conta;
import com.zupedu.bancodigital.domain.correntista.Correntista;
import com.zupedu.bancodigital.domain.conta.Tipo;
import com.zupedu.bancodigital.adapters.repository.CorrentistaRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaContaRequest {

    @NotNull
    private Tipo tipo;

    @Positive
    @NotNull
    private Long correntistaId;

    public Tipo getTipo() {
        return tipo;
    }

    public Long getCorrentistaId() {
        return correntistaId;
    }

    public Conta paraConta(CorrentistaRepository correntistaRepository) {
        Correntista correntista = correntistaRepository.findById(correntistaId)
                                                       .orElseThrow(() -> new IllegalStateException("Correntista nao cadastrado"));
        return new Conta(tipo, correntista);
    }
}
