package br.com.estudo.custodia.core.domain;

import java.math.BigDecimal;
import java.util.List;

public class Liquidacao {
    private String numeroContrato;
    private List<Parcela> fluxoParcelas;
    private BigDecimal valorTotal;
    private Integer motivoBaixa;

    public Liquidacao(String numeroContrato, List<Parcela> fluxoParcelas, BigDecimal valorTotal, Integer motivoBaixa) {
        this.numeroContrato = numeroContrato;
        this.fluxoParcelas = fluxoParcelas;
        this.valorTotal = valorTotal;
        this.motivoBaixa = motivoBaixa;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public List<Parcela> getFluxoParcelas() {
        return fluxoParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Integer getMotivoBaixa() {
        return motivoBaixa;
    }

    @Override
    public String toString() {
        return "EventoLiquidacaoCPR{" +
                "numeroContrato='" + numeroContrato + '\'' +
                ", fluxoParcelas=" + fluxoParcelas +
                ", valorTotal=" + valorTotal +
                ", motivoBaixa=" + motivoBaixa +
                '}';
    }
}
