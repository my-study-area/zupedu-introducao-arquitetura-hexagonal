package br.com.zup.edu.pharmacia.domain;

import br.com.zup.edu.pharmacia.domain.categoria.Categoria;

public interface RemedioRequestInputPort {
    public Remedio toModel(Categoria categoria);
}