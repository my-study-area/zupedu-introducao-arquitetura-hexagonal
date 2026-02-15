package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;

public abstract class LiquidacaoMapper {
    public abstract Liquidacao toModel(Object liquidacao);
    public abstract boolean isValid(EventoBase eventoBase);
}
