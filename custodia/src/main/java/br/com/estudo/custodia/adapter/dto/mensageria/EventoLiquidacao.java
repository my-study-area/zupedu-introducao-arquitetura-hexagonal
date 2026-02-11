package br.com.estudo.custodia.adapter.dto.mensageria;

import java.math.BigDecimal;
import java.util.List;

public class EventoLiquidacao {
    private String numeroContrato;
    private List<EventoParcela> fluxoEventoParcelas;
    private BigDecimal valorTotal;
    private Integer motivoBaixa;

    public EventoLiquidacao(String numeroContrato, List<EventoParcela> fluxoEventoParcelas, BigDecimal valorTotal, Integer motivoBaixa) {
        this.numeroContrato = numeroContrato;
        this.fluxoEventoParcelas = fluxoEventoParcelas;
        this.valorTotal = valorTotal;
        this.motivoBaixa = motivoBaixa;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public List<EventoParcela> getFluxoParcelas() {
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
        return "EventoLiquidacaoCPR{" +
                "numeroContrato='" + numeroContrato + '\'' +
                ", fluxoParcelas=" + fluxoEventoParcelas +
                ", valorTotal=" + valorTotal +
                ", motivoBaixa=" + motivoBaixa +
                '}';
    }
}
