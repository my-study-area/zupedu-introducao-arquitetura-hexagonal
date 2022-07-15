package br.com.zup.edu.cineminha.application;

import br.com.zup.edu.cineminha.domain.filme.CadastraNovoFilmeService;
import br.com.zup.edu.cineminha.domain.Sessao;
import br.com.zup.edu.cineminha.adapters.persistence.sala.SalaRepository;

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

    public Sessao toModel(SalaRepository salas, CadastraNovoFilmeService filmeService) {

        var sala = salas.findById(salaId).orElseThrow(() -> new IllegalStateException("Sala nao existe"));
        var filme = filmeService.buscarPorId(filmeId).orElseThrow(() -> new IllegalStateException("Filme nao existe"));

        return new Sessao(horario, sala, filme, preco);

    }
}
