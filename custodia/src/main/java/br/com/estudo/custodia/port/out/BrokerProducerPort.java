package br.com.estudo.custodia.port.out;

import br.com.estudo.custodia.core.domain.EventoRetorno;

public interface BrokerProducerPort {
    void send(EventoRetorno evento);
}
