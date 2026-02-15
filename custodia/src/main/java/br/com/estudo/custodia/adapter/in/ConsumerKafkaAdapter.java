package br.com.estudo.custodia.adapter.in;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapperFactory;
import br.com.estudo.custodia.adapter.mapper.MapperLiquidacaoDinamico;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoModernizadoService;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerKafkaAdapter {
    private final Logger logger = LoggerFactory.getLogger(ConsumerKafkaAdapter.class);
    private final LiquidacaoService liquidacoesUseCaseLegado;
    private final LiquidacaoModernizadoService liquidacoesUseCaseModernizado;
    private final LiquidacaoMapperFactory liquidacaoMapperFactory;

    public ConsumerKafkaAdapter(LiquidacaoService liquidacoesUseCaseLegado, LiquidacaoModernizadoService liquidacoesUseCaseModernizado, LiquidacaoMapperFactory liquidacaoMapperFactory) {
        this.liquidacoesUseCaseLegado = liquidacoesUseCaseLegado;
        this.liquidacoesUseCaseModernizado = liquidacoesUseCaseModernizado;
        this.liquidacaoMapperFactory = liquidacaoMapperFactory;
    }

    public void consumir(EventoBase evento) {
        try {
            logger.info("Consumindo evento: {}", evento);
            MapperLiquidacaoDinamico mapper = liquidacaoMapperFactory.build(evento);
            Liquidacao liquidacao = mapper.toModel(evento.getData());
            liquidacoesUseCaseLegado.liquidar(liquidacao);
            liquidacoesUseCaseModernizado.liquidar(liquidacao);
            logger.info("Finaliza consumo do evento");
        } catch (Exception e) {
            logger.error("Erro ao consumir evento: {}", e.getMessage());
        }
    }

}
