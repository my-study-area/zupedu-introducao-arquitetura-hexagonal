package br.com.estudo.custodia;

import br.com.estudo.custodia.adapter.out.LiquidarRestClientAdapter;
import br.com.estudo.custodia.adapter.out.ProducerPortKafkaAdapter;
import br.com.estudo.custodia.adapter.out.dto.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.out.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.core.domain.Evento;
import br.com.estudo.custodia.core.domain.EventoRetorno;
import br.com.estudo.custodia.core.domain.Header;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.Parcela;
import br.com.estudo.custodia.core.domain.RespostaHttp;
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
        Parcela parcela1 = new Parcela(1, LocalDate.now(), new BigDecimal(5));
        Parcela parcela2 = new Parcela(2, LocalDate.now(), new BigDecimal(5));
        List<Parcela> parcelas = List.of(parcela1, parcela2);
        Liquidacao liquidacao = new Liquidacao("0123", parcelas, BigDecimal.TEN, 0);
        Header header = new Header(UUID.randomUUID().toString(), "topico1");
        Evento<Liquidacao> evento = new Evento<>(header, liquidacao);
        logger.info("Evento: {}", evento.getData());

        // Request API liquidação
        LiquidacaoRequestDTO requestDTO = LiquidacaoMapper.toRequestDTO(evento.getData());
        LiquidarHttpClientPort clientPort = new LiquidarRestClientAdapter("http://localhost:8080", "/v1/baixar");
        RespostaHttp responseHttp = clientPort.post(requestDTO);
        logger.info("Res1: {}", responseHttp.getBody());


        // Envio de resposta de mensageria
        EventoRetorno eventoRetorno = new EventoRetorno(responseHttp, liquidacao);
        BrokerProducerPort producerKafkaAdapter = new ProducerPortKafkaAdapter();
        producerKafkaAdapter.send(eventoRetorno);


    }
}
