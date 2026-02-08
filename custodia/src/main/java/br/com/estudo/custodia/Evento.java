package br.com.estudo.custodia;

public class Evento<T> {
    private Header header;
    private T data;

    public Evento() {
    }

    public Evento(Header header, T data) {
        this.header = header;
        this.data = data;
    }

    public Header getHeader() {
        return header;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }
}
