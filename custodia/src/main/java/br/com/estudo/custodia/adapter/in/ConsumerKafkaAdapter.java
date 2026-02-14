package br.com.estudo.custodia.adapter.in;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.adapter.dto.mensageria.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerKafkaAdapter {
    private final Logger logger = LoggerFactory.getLogger(ConsumerKafkaAdapter.class);

    private final LiquidacaoService liquidacaoUseCase;

    public ConsumerKafkaAdapter(LiquidacaoService liquidacaoUseCase) {
        this.liquidacaoUseCase = liquidacaoUseCase;
    }

    public void consumir(EventoBase evento) {
        logger.info("Consumindo evento: {}", evento);
        Liquidacao liquidacao = (Liquidacao) evento.getData();
        liquidacaoUseCase.liquidar(liquidacao);
    }
}
