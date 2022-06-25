package com.zupedu.bancodigital.cadastrarProposta;

public interface BancoDeDadosRepositoryPort<M> {
    void cadastrar(M model);
}
