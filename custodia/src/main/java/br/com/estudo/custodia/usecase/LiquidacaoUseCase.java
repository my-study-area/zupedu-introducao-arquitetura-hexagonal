package br.com.estudo.custodia.usecase;

import br.com.estudo.custodia.adapter.dto.api.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoRetorno;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import br.com.estudo.custodia.port.out.BrokerProduceRetornoPort;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiquidacaoUseCase implements LiquidacaoService {
    private static final Logger logger = LoggerFactory.getLogger(LiquidacaoUseCase.class);
    private final LiquidacaoMapper mapper;
    private final LiquidarHttpClientPort client;
    private final BrokerProduceRetornoPort broker;

    public LiquidacaoUseCase(LiquidacaoMapper mapper, LiquidarHttpClientPort client, BrokerProduceRetornoPort broker) {
        this.mapper = mapper;
        this.client = client;
        this.broker = broker;
    }

    @Override
    public void liquidar(Liquidacao liquidacao) {
        logger.info("Iniciando o fluxo de liquidação legado");
        LiquidacaoRequestDTO requestDTO = mapper.toDTO(liquidacao);
        RespostaHttp respostaHttp = client.post(requestDTO);
        EventoRetorno eventoRetorno = new EventoRetorno(respostaHttp, liquidacao);
        broker.send(eventoRetorno);
    }
}
