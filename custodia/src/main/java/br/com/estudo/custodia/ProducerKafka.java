package br.com.estudo.custodia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerKafka {
    private Logger logger = LoggerFactory.getLogger(ProducerKafka.class);
    private final EventoRetorno eventoRetorno;

    public ProducerKafka(EventoRetorno eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }

    public void send() {
        logger.info("Enviando evento para tópico: {}", eventoRetorno);
    }
}
