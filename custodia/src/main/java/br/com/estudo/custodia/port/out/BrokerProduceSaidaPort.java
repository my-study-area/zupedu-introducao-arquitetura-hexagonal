package br.com.estudo.custodia.port.out;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoKafka;

public interface BrokerProduceSaidaPort {
    void send(EventoKafka evento);
}
