package br.com.estudo.custodia;

import br.com.estudo.custodia.adapter.dto.api.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;
import br.com.estudo.custodia.adapter.dto.mensageria.Evento;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoLiquidacao;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoRetorno;
import br.com.estudo.custodia.adapter.dto.mensageria.Header;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.adapter.out.LiquidarRestClientAdapter;
import br.com.estudo.custodia.adapter.out.ProducerPortKafkaAdapter;
import br.com.estudo.custodia.port.out.BrokerProducerPort;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        // Evento
        EventoParcela eventoParcela1 = new EventoParcela(1, LocalDate.now(), new BigDecimal(5));
        EventoParcela eventoParcela2 = new EventoParcela(2, LocalDate.now(), new BigDecimal(5));
        List<EventoParcela> eventoParcelas = List.of(eventoParcela1, eventoParcela2);
        EventoLiquidacao eventoLiquidacao = new EventoLiquidacao("0123", eventoParcelas, BigDecimal.TEN, 0);
        Header header = new Header(UUID.randomUUID().toString(), "topico1");
        Evento<EventoLiquidacao> evento = new Evento<>(header, eventoLiquidacao);
        logger.info("Evento: {}", evento.getData());

        // Request API liquidação
        LiquidacaoRequestDTO requestDTO = LiquidacaoMapper.toRequestDTO(evento.getData());
        LiquidarHttpClientPort clientPort = new LiquidarRestClientAdapter("http://localhost:8080", "/v1/baixar");
        RespostaHttp responseHttp = clientPort.post(requestDTO);
        logger.info("Res1: {}", responseHttp.getBody());


        // Envio de resposta de mensageria
        EventoRetorno eventoRetorno = new EventoRetorno(responseHttp, eventoLiquidacao);
        BrokerProducerPort producerKafkaAdapter = new ProducerPortKafkaAdapter();
        producerKafkaAdapter.send(eventoRetorno);


    }
}
