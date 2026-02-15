package br.com.estudo.custodia.adapter.dto.mensageria;

import br.com.estudo.custodia.core.domain.Liquidacao;

public class EventoEntradaSistemaModerno extends EventoKafka {
    private String numeroContratoModernizado;


    public EventoEntradaSistemaModerno(Liquidacao evento, String numeroContratoModernizado) {
        super(evento);
        this.numeroContratoModernizado = numeroContratoModernizado;
    }

    @Override
    public String toString() {
        return "EventoEntradaSistemaModerno{" +
                "numeroContratoModernizado='" + numeroContratoModernizado + '\'' +
                ", evento=" + evento +
                '}';
    }
}
