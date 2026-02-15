package br.com.estudo.custodia.adapter.out;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoKafka;
import br.com.estudo.custodia.port.out.BrokerProduceRetornoPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProduceRetornoRetornoKafkaAdapter implements BrokerProduceRetornoPort {
    private Logger logger = LoggerFactory.getLogger(ProduceRetornoRetornoKafkaAdapter.class);

    public void send(EventoKafka eventoRetorno) {
        logger.info("Produzindo evento no tópico de retorno: {}", eventoRetorno);
    }

}
