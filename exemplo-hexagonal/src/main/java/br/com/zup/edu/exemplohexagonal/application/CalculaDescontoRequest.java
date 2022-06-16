package br.com.zup.edu.exemplohexagonal.application;

import javax.validation.constraints.Positive;

public class CalculaDescontoRequest {
    @Positive
    private double valor;

    public double getValor() {
        return valor;
    }
}
