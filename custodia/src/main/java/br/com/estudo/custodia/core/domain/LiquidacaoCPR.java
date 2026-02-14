package br.com.estudo.custodia.core.domain;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;

import java.math.BigDecimal;
import java.util.List;

public class LiquidacaoCPR {
    private String numeroContratoLegado;
    private List<EventoParcela> fluxoEventoParcelas;
    private BigDecimal valorTotal;
    private Integer motivoBaixa;

    public LiquidacaoCPR(String numeroContratoLegado, List<EventoParcela> fluxoEventoParcelas, BigDecimal valorTotal, Integer motivoBaixa) {
        this.numeroContratoLegado = numeroContratoLegado;
        this.fluxoEventoParcelas = fluxoEventoParcelas;
        this.valorTotal = valorTotal;
        this.motivoBaixa = motivoBaixa;
    }

    public String getNumeroContratoLegado() {
        return numeroContratoLegado;
    }

    public List<EventoParcela> getFluxoEventoParcelas() {
        return fluxoEventoParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Integer getMotivoBaixa() {
        return motivoBaixa;
    }

    @Override
    public String toString() {
        return "LiquidacaoCPR{" +
                "numeroContratoLegado='" + numeroContratoLegado + '\'' +
                ", fluxoEventoParcelas=" + fluxoEventoParcelas +
                ", valorTotal=" + valorTotal +
                ", motivoBaixa=" + motivoBaixa +
                '}';
    }
}
