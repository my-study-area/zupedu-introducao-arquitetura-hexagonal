package br.com.estudo.custodia.core.domain;

public class EventoRetorno {
    private RespostaHttp retorno;
    private Liquidacao evento;

    public EventoRetorno(RespostaHttp retorno, Liquidacao evento) {
        this.retorno = retorno;
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "EventoRetorno{" +
                "retorno=" + retorno +
                ", evento=" + evento +
                '}';
    }
}
