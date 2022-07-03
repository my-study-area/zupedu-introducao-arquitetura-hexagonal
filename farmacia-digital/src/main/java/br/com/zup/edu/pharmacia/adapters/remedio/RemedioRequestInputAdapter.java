package br.com.zup.edu.pharmacia.adapters.remedio;

import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import br.com.zup.edu.pharmacia.domain.remedio.Remedio;
import br.com.zup.edu.pharmacia.domain.remedio.RemedioRequestInputPort;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RemedioRequestInputAdapter implements RemedioRequestInputPort {
    @NotBlank
    private String nome;

    @NotBlank
    private String farmaceutica;

    @NotNull
    private Long categoriaId;

    @NotNull
    private LocalDate dataFabricacao;

    @NotNull
    private LocalDate dataValidade;

    public RemedioRequestInputAdapter(@NotBlank String nome,
                                      @NotBlank String farmaceutica,
                                      @NotNull Long categoriaId,
                                      @NotNull LocalDate dataFabricacao,
                                      @NotNull LocalDate dataValidade) {
        this.nome = nome;
        this.farmaceutica = farmaceutica;
        this.categoriaId = categoriaId;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    @Override
    public Remedio toModel(Categoria categoria) {
        return new Remedio(nome, farmaceutica, categoria, dataFabricacao, dataValidade);
    }

    public Long getCategoriaId() {
        return this.categoriaId;
    }
}
