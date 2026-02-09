package br.com.estudo.custodia.port.out;

import br.com.estudo.custodia.core.domain.RespostaHttp;

public interface LiquidarHttpClientPort {
    RespostaHttp post(Object body);
}
