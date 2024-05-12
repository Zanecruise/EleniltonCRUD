package com.example.demo.Repository;

public interface InterfaceRepository {

    public void inserir(String tabela, String descricao, int id);

    public void atualizar(String tabela, String descricao, int id);

    public void excluir(String tabela, int id);


}
