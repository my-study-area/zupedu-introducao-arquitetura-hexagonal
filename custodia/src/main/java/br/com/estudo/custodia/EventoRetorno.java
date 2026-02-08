package br.com.estudo.custodia;

import org.springframework.http.ResponseEntity;

public class EventoRetorno {
    private ResponseEntity response;
    private  EventoLiquidacao evento;

    public EventoRetorno(ResponseEntity response, EventoLiquidacao evento) {
        this.response = response;
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "EventoRetorno{" +
                "response=" + response +
                ", evento=" + evento +
                '}';
    }
}
