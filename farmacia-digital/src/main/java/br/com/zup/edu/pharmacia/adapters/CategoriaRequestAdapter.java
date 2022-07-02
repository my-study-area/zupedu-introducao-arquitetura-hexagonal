package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.Categoria;
import br.com.zup.edu.pharmacia.domain.CategoriaRequestInputPort;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class CategoriaRequestAdapter implements CategoriaRequestInputPort {
    @NotBlank
    private String nome;

    public CategoriaRequestAdapter() {
    }

    public CategoriaRequestAdapter(@NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public Categoria toModel() {
        return new Categoria(nome);
    }

    public String getNome() {
        return nome;
    }
}
