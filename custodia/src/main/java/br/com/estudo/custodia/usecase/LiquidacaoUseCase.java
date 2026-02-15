package br.com.estudo.custodia.usecase;

import br.com.estudo.custodia.adapter.dto.api.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoRetorno;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoRequestDTOMapper;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import br.com.estudo.custodia.port.out.BrokerProducerPort;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;

public class LiquidacaoUseCase implements LiquidacaoService {
    private final LiquidacaoRequestDTOMapper mapper;
    private final LiquidarHttpClientPort client;
    private final BrokerProducerPort broker;

    public LiquidacaoUseCase(LiquidacaoRequestDTOMapper mapper, LiquidarHttpClientPort client, BrokerProducerPort broker) {
        this.mapper = mapper;
        this.client = client;
        this.broker = broker;
    }

    @Override
    public void liquidar(Liquidacao liquidacao) {
        LiquidacaoRequestDTO requestDTO = mapper.toDTO(liquidacao);
        RespostaHttp respostaHttp = client.post(requestDTO);
        EventoRetorno eventoRetorno = new EventoRetorno(respostaHttp, liquidacao);
        broker.send(eventoRetorno);
    }
}
