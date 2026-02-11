package br.com.estudo.custodia;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoLiquidacao;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;

import java.math.BigDecimal;
import java.util.List;

public class EventoLiquidacaoCPR extends EventoLiquidacao {

    public EventoLiquidacaoCPR(String numeroContrato, List<EventoParcela> fluxoEventoParcelas, BigDecimal valorTotal, Integer motivoBaixa) {
        super(numeroContrato, fluxoEventoParcelas, valorTotal, motivoBaixa);
    }
    
}
