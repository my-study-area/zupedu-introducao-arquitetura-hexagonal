package br.com.estudo.custodia.core.domain;

import br.com.estudo.custodia.adapter.dto.mensageria.Liquidacao;

public interface LiquidacaoService {
    void liquidar(Liquidacao liquidacao);
}
