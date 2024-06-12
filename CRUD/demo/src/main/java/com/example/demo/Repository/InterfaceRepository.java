package com.example.demo.Repository;

public interface InterfaceRepository {

    public void inserir(String name, String birthdate, String phone, String email, String lotNumber, String complement, int sangue, int civil, int gender, int cep);

    public void atualizar(String name, String birthdate, String phone, String email, String lotNumber, String complement, int sangue, int civil, int gender, int cep,int id);

    public void excluir(int id);

}
