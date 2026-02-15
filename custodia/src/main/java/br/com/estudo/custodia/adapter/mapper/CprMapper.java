package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoCPR;

public class CprMapper implements MapperLiquidacaoDinamico {
    public Liquidacao toModel(Object liquidacao) {
        //Pattern Matching para o operador instanceof
        if (!(liquidacao instanceof LiquidacaoCPR liquidacaoCPR)) {
            throw new IllegalArgumentException("Deve ser uma Liquidação de CPR");
        }
        return new Liquidacao(
                liquidacaoCPR.getNumeroContratoLegado(),
                liquidacaoCPR.getFluxoEventoParcelas(),
                liquidacaoCPR.getValorTotal(),
                liquidacaoCPR.getMotivoBaixa());
    }

    public boolean canHandle(EventoBase eventoBase) {
        return eventoBase.getData() instanceof LiquidacaoCPR;
    }
}
