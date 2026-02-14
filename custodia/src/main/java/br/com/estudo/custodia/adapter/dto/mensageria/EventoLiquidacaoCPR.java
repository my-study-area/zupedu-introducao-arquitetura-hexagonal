package br.com.estudo.custodia.adapter.dto.mensageria;

import br.com.estudo.custodia.core.domain.LiquidacaoCPR;

public class EventoLiquidacaoCPR implements EventoBase {
    private Header header;
    private LiquidacaoCPR data;

    public EventoLiquidacaoCPR(Header header, LiquidacaoCPR data) {
        this.header = header;
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventoLiquidacaoCPR{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public LiquidacaoCPR getData() {
        return data;
    }
}
