package br.com.estudo.custodia.core.domain;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;

import java.math.BigDecimal;
import java.util.List;

public class LiquidacaoNCE {
    private String numeroOperacaoBoleto;
    private List<EventoParcela> fluxoEventoParcelas;
    private BigDecimal valorTotal;
    private Integer motivoBaixa;

    public LiquidacaoNCE(String numeroOperacaoBoleto, List<EventoParcela> fluxoEventoParcelas, BigDecimal valorTotal, Integer motivoBaixa) {
        this.numeroOperacaoBoleto = numeroOperacaoBoleto;
        this.fluxoEventoParcelas = fluxoEventoParcelas;
        this.valorTotal = valorTotal;
        this.motivoBaixa = motivoBaixa;
    }

    public String getNumeroOperacaoBoleto() {
        return numeroOperacaoBoleto;
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
        return "LiquidacaoNCE{" +
                "numeroOperacaoBoleto='" + numeroOperacaoBoleto + '\'' +
                ", fluxoEventoParcelas=" + fluxoEventoParcelas +
                ", valorTotal=" + valorTotal +
                ", motivoBaixa=" + motivoBaixa +
                '}';
    }
}
