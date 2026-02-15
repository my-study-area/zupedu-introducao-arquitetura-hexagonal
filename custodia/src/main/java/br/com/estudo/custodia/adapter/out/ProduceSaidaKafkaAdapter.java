package br.com.estudo.custodia.adapter.out;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoKafka;
import br.com.estudo.custodia.port.out.BrokerProduceSaidaPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProduceSaidaKafkaAdapter implements BrokerProduceSaidaPort {
    private Logger logger = LoggerFactory.getLogger(ProduceSaidaKafkaAdapter.class);

    public void send(EventoKafka eventoRetorno) {
        logger.info("Produzindo evento no tópico de saída para o sistema modernizado: {}", eventoRetorno);
    }

}
