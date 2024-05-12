package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Crud implements InterfaceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Crud(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void inserir(String nomeTabela, String descricao, int id) {

        String sql = "INSERT INTO " + nomeTabela + " (descricao) VALUES (?) ";

        jdbcTemplate.update(sql, descricao);

    }

    @Override
    public void atualizar(String nomeTabela, String descricao, int id) {
        // Consulta SQL para atualizar a descrição com base no ID
        String sql = "UPDATE " + nomeTabela + " SET descricao = ? WHERE id = ? ";

        // Executar a atualização usando o JdbcTemplate
        jdbcTemplate.update(sql, descricao, id);
    }

    @Override
    public void excluir(String nomeTabela, int id) {
        // Consulta SQL para excluir o registro com base no ID
        String sql = "DELETE FROM " + nomeTabela + " WHERE id = ? ";

        // Executar a exclusão usando o JdbcTemplate
        jdbcTemplate.update(sql, id);
    }

    
    public void inserirPessoa(int id) {

        String sql = "INSERT INTO Pessoa (id_nome, id_genero, id_data_nascimento, id_email, id_celular, id_endereco) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, id, id, id, id, id, id);

    }

    
    

    public int getIDNome(String descricao) {

        String sql = "SELECT id FROM nome WHERE descricao = ?";

        int id = jdbcTemplate.queryForObject(sql, Integer.class, descricao);

        return id;
    }

    public void inserirEstado(String descricao, int id) {

        String sql = "INSERT INTO Estado (descricao, id_pais) VALUES (?, ?)";

        jdbcTemplate.update(sql, descricao, id);

    }

    public void inserirCidade(String descricao, int id) {

        String sql = "INSERT INTO Cidade (descricao, id_estado) VALUES (?, ?)";

        jdbcTemplate.update(sql, descricao, id);

    }

    public void inserirRua(String descricao, int id) {

        String sql = "INSERT INTO Rua (descricao, id_cidade) VALUES (?, ?)";

        jdbcTemplate.update(sql, descricao, id);

    }

    public void inserirBairro(String descricao, int id) {

        String sql = "INSERT INTO Bairro (descricao, id_rua) VALUES (?, ?)";

        jdbcTemplate.update(sql, descricao, id);

    }

    public void inserirEndereco(int id) {

        String sql = "INSERT INTO Endereco (id_numero) VALUES (?)";

        jdbcTemplate.update(sql, id);

    }

    public void inserirNumeroLote(String descricao, int id) {

        String sql = "INSERT INTO Numero_Lote (descricao, id_complemento, id_bairro) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, descricao, id, id);

    }
    

}
