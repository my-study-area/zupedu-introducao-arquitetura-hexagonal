package br.com.estudo.custodia.adapter.dto.mensageria;

import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;

public class EventoRetorno {
    private RespostaHttp retorno;
    private Liquidacao evento;

    public EventoRetorno(RespostaHttp retorno, Liquidacao evento) {
        this.retorno = retorno;
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "EventoRetorno{" +
                "retorno=" + retorno +
                ", evento=" + evento +
                '}';
    }
}
