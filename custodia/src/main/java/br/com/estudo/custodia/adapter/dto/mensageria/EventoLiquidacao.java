package br.com.estudo.custodia.adapter.dto.mensageria;

public class EventoLiquidacao implements EventoBase {
    private Header header;
    private Liquidacao data;

    public EventoLiquidacao(Header header, Liquidacao data) {
        this.header = header;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public Liquidacao getData() {
        return data;
    }
}
