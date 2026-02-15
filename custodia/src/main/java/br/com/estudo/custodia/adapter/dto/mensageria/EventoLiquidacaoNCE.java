package br.com.estudo.custodia.adapter.dto.mensageria;

import br.com.estudo.custodia.core.domain.LiquidacaoNCE;

public class EventoLiquidacaoNCE implements EventoBase {
    private Header header;
    private LiquidacaoNCE data;

    public EventoLiquidacaoNCE(Header header, LiquidacaoNCE data) {
        this.header = header;
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventoLiquidacaoNCE{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public LiquidacaoNCE getData() {
        return data;
    }
}
