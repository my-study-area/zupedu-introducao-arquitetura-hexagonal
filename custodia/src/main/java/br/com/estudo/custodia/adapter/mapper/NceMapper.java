package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoNCE;

public class NceMapper implements MapperLiquidacaoDinamico {
    @Override
    public Liquidacao toModel(Object liquidacao) {
        //Pattern Matching para o operador instanceof
        if (!(liquidacao instanceof LiquidacaoNCE liquidacaoNCE)) {
            throw new IllegalArgumentException("Deve ser uma Liquidação de NCE");
        }
        return new Liquidacao(
                liquidacaoNCE.getNumeroOperacaoBoleto(),
                liquidacaoNCE.getFluxoEventoParcelas(),
                liquidacaoNCE.getValorTotal(),
                liquidacaoNCE.getMotivoBaixa());
    }

    @Override
    public boolean canHandle(EventoBase eventoBase) {
        return eventoBase.getData() instanceof LiquidacaoNCE;
    }
}
