package br.com.estudo.custodia.adapter.out;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoRetorno;
import br.com.estudo.custodia.port.out.BrokerProducerPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerKafkaAdapter implements BrokerProducerPort {
    private Logger logger = LoggerFactory.getLogger(ProducerKafkaAdapter.class);

    public void send(EventoRetorno eventoRetorno) {
        logger.info("Produzindo evento no tópico de retorno: {}", eventoRetorno);
    }

}
