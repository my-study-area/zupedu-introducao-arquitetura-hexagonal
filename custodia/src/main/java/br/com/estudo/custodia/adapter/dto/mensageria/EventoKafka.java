package br.com.estudo.custodia.adapter.dto.mensageria;

import br.com.estudo.custodia.core.domain.Liquidacao;

public class EventoKafka {

    protected Liquidacao evento;

    public EventoKafka(Liquidacao evento) {
        this.evento = evento;
    }
}
