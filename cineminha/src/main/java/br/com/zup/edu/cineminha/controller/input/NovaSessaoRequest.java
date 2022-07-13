package br.com.zup.edu.cineminha.controller.input;

import br.com.zup.edu.cineminha.model.Sessao;
import br.com.zup.edu.cineminha.repository.FilmeRepository;
import br.com.zup.edu.cineminha.adapters.persistence.SalaRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalTime;

public class NovaSessaoRequest {

    @NotNull
    private LocalTime horario;

    @Positive
    private long salaId;

    @Positive
    private long filmeId;

    @Positive
    private BigDecimal preco;

    public LocalTime getHorario() {
        return horario;
    }

    public long getSalaId() {
        return salaId;
    }

    public long getFilmeId() {
        return filmeId;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Sessao toModel(SalaRepository salas, FilmeRepository filmes) {

        var sala = salas.findById(salaId).orElseThrow(() -> new IllegalStateException("Sala nao existe"));
        var filme = filmes.findById(filmeId).orElseThrow(() -> new IllegalStateException("Filme nao existe"));

        return new Sessao(horario, sala, filme, preco);

    }
}
