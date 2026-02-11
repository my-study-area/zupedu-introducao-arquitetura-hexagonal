package br.com.estudo.custodia.port.out;

import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;

public interface LiquidarHttpClientPort {
    RespostaHttp post(Object body);
}
