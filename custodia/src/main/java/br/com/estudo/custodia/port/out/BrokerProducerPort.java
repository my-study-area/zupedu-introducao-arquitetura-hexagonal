package br.com.estudo.custodia.port.out;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoRetorno;

public interface BrokerProducerPort {
    void send(EventoRetorno evento);
}
