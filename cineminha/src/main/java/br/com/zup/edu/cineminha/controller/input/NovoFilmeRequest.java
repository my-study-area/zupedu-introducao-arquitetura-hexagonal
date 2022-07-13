package br.com.zup.edu.cineminha.controller.input;

import br.com.zup.edu.cineminha.model.Classificacao;
import br.com.zup.edu.cineminha.model.Filme;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Duration;

public class NovoFilmeRequest {

    @NotBlank
    private String nome;

    @Positive
    private long duracaoEmMinutos;

    @NotNull
    private Classificacao classificacao;


    public String getNome() {
        return nome;
    }

    public long getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Filme toModel() {

        return new Filme(nome, Duration.ofMinutes(duracaoEmMinutos), classificacao);

    }
}
