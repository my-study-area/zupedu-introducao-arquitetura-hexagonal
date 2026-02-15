package br.com.estudo.custodia.adapter.dto.mensageria;

import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;
import br.com.estudo.custodia.core.domain.Liquidacao;

public class EventoRetorno extends EventoKafka {
    protected RespostaHttp retorno;

    public EventoRetorno(RespostaHttp retorno, Liquidacao evento) {
        super(evento);
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return "EventoRetorno{" +
                "retorno=" + retorno +
                ", evento=" + evento +
                '}';
    }
}
