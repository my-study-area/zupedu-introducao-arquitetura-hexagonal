package br.com.zup.edu.pharmacia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String farmaceutica;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    private LocalDate dataFabricacao;

    @NotNull
    private LocalDate dataValidade;

    public Remedio(@NotBlank String nome,
                   @NotBlank String farmaceutica,
                   @NotNull Categoria categoria,
                   @NotNull LocalDate dataFabricacao,
                   @NotNull LocalDate dataValidade) {
        this.nome = nome;
        this.farmaceutica = farmaceutica;
        this.categoria = categoria;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    public Long getId() {
        return id;
    }
}
