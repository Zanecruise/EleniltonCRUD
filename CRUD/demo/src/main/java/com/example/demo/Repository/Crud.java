package com.example.demo.Repository;

import java.util.Map;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class Crud implements InterfaceRepository {

    private static List<Map<String, Object>> pessoa;

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

        String sql = "INSERT INTO Pessoa (id_nome, id_genero, id_data_nascimento, id_email, id_celular,  id_complemento) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, id, id, id, id, id, id);

    }


    public int getIDNome(String descricao) {

        String sql = "SELECT id FROM Celular WHERE descricao = ?";

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

    public void inserirComplemento(String descricao, int id) {

        String sql = "INSERT INTO Complemento (descricao, id_numero) VALUES (?, ?)";

        jdbcTemplate.update(sql, descricao, id);

    }

    public void inserirNumeroLote(String descricao, int id) {

        String sql = "INSERT INTO Numero_Lote (descricao, id_bairro) VALUES (?, ?)";

        jdbcTemplate.update(sql, descricao, id);

    }

    public List<Map<String, Object>> getPessoas() {

        String sql = "SELECT e.descricao AS estado, " +
                        "       p.descricao AS pais, " +
                        "       c.descricao AS cidade, " +
                        "       r.descricao AS rua, " +
                        "       b.descricao AS bairro, " +
                        "       nl.descricao AS numero_lote, " +
                        "       cp.descricao AS complemento, " +
                        "       nm.descricao AS nome, " +
                        "       eml.descricao AS email, " +
                        "       cll.descricao AS celular, " +
                        "       dn.descricao AS data_nascimento, " +
                        "       gn.descricao AS genero " +
                        "FROM estado e " +
                        "JOIN pais p ON e.id_pais = p.id " +
                        "JOIN cidade c ON c.id_estado = e.id " +
                        "JOIN rua r ON r.id_cidade = c.id " +
                        "JOIN bairro b ON b.id_rua = r.id " +
                        "JOIN numero_lote nl ON nl.id_bairro = b.id " +
                        "JOIN complemento cp ON cp.id_numero = nl.id " +
                        "JOIN pessoa pss ON pss.id_complemento = cp.id " +
                        "JOIN nome nm ON nm.id = pss.id_nome " +
                        "JOIN email eml ON eml.id = pss.id_email " +
                        "JOIN celular cll ON cll.id = pss.id_celular " +
                        "JOIN data_nascimento dn ON dn.id = pss.id_data_nascimento " +
                        "JOIN genero gn ON gn.id = pss.id_genero " 
                        ;
                        

        pessoa = jdbcTemplate.queryForList(sql);

        return pessoa;
    }
    

}
