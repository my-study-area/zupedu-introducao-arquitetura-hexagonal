package br.com.estudo.custodia;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Parcela {
    private int numeroParcela;
    private LocalDate dataVencimento;
    private BigDecimal valor;

    public Parcela(int numeroParcela, LocalDate dataVencimento, BigDecimal valor) {
        this.numeroParcela = numeroParcela;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "numeroParcela=" + numeroParcela +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                '}';
    }
}
