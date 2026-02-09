package br.com.estudo.custodia.adapter.out;

import br.com.estudo.custodia.core.domain.EventoRetorno;
import br.com.estudo.custodia.port.out.BrokerProducerPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerPortKafkaAdapter implements BrokerProducerPort {
    private Logger logger = LoggerFactory.getLogger(ProducerPortKafkaAdapter.class);

    public void send(EventoRetorno eventoRetorno) {
        logger.info("Enviando evento: {}", eventoRetorno);
    }

}
