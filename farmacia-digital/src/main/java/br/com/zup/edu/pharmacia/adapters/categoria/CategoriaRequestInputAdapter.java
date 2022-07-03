package br.com.zup.edu.pharmacia.adapters.categoria;

import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import br.com.zup.edu.pharmacia.domain.categoria.CategoriaRequestInputPort;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class CategoriaRequestInputAdapter implements CategoriaRequestInputPort {
    @NotBlank
    private String nome;

    public CategoriaRequestInputAdapter() {
    }

    public CategoriaRequestInputAdapter(@NotBlank String nome) {
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
