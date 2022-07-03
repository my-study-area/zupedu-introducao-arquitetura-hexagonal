package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.Categoria;
import br.com.zup.edu.pharmacia.domain.CategoriaService;
import br.com.zup.edu.pharmacia.domain.Remedio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RemedioRequest {
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

    public RemedioRequest(@NotBlank String nome,
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

    public Remedio toModel(CategoriaService categoriaService) throws Exception {
        Categoria categoria = categoriaService.buscarPorId(this.categoriaId);
        return new Remedio(nome, farmaceutica, categoria, dataFabricacao, dataValidade);
    }
}
