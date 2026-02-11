package br.com.estudo.custodia.adapter.dto.mensageria;

public class Header {
    private String id;
    private String topico;

    public Header(String id, String topico) {
        this.id = id;
        this.topico = topico;
    }

    @Override
    public String toString() {
        return "Header{" +
                "id='" + id + '\'' +
                ", topico='" + topico + '\'' +
                '}';
    }
}
