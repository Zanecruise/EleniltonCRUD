package com.example.demo.Repository;

import java.util.Map;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class Crud implements InterfaceRepository {

    private static List<Map<String, Object>> pessoa;

    private static List<Map<String, Object>> CEPS;

    private static List<Map<String, Object>> SANGUES;

    private static List<Map<String, Object>> CIVIL;

    

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

    
    public void inserirPessoa(String name, String birthdate, String gender, int sangue, int civil, String phone, String email) {

        String sql = "INSERT INTO Pessoa (nome, data_nascimento, genero, id_tipo_sanguineo, id_estado_civil, celular, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, name, birthdate, gender, sangue, civil, phone, email);

    }

    public void inserirEndereco(String complement, String lotNumber, int id_pessoa, int cep) {

        String sql = "INSERT INTO endereco (complemento, numero, id_pessoa, id_cep) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, complement, lotNumber, id_pessoa, cep);

    }


    public int getIDNome(String descricao) {

        String sql = "SELECT id FROM pessoa WHERE nome = ?";

        int id = jdbcTemplate.queryForObject(sql, Integer.class, descricao);

        return id;
    }


    public List<Map<String, Object>> getPessoas() {

        String sql = "SELECT ed.id_cep AS id_cep, ps.descricao AS pais, e.descricao AS estado, c.descricao AS cidade, b.descricao AS bairro, l.descricao AS logradouro, cp.descricao AS cep, ed.complemento AS complemento, ed.numero AS numero, p.nome, p.data_nascimento, p.genero, p.celular, p.email, ts.descricao AS tipo_sanguineo, ec.descricao AS estado_civil FROM pais ps " +
        "JOIN estado e ON e.id_pais = ps.id " +
        "JOIN cidade c ON c.id_estado = e.id " +
        "JOIN bairro b ON b.id_cidade = c.id " +
        "JOIN logradouro l ON l.id_bairro = b.id " +
        "JOIN cep cp ON cp.id_logradouro = l.id " +
        "JOIN endereco ed ON ed.id_cep = cp.id " +
        "JOIN pessoa p ON p.id = ed.id_pessoa " +
        "JOIN tipo_sanguineo ts ON ts.id = p.id_tipo_sanguineo " +
        "JOIN estado_civil ec ON ec.id = p.id_estado_civil ";
        
        
                        

        pessoa = jdbcTemplate.queryForList(sql);

        return pessoa;
    }

    public List<Map<String, Object>> getCEPS() {

        String sql = "SELECT ps.descricao AS pais, e.descricao AS estado, c.descricao AS cidade, b.descricao AS bairro, l.descricao AS logradouro, cp.descricao AS cep FROM pais ps " +
        "JOIN estado e ON e.id_pais = ps.id " +
        "JOIN cidade c ON c.id_estado = e.id " +
        "JOIN bairro b ON b.id_cidade = c.id " +
        "JOIN logradouro l ON l.id_bairro = b.id " +
        "JOIN cep cp ON cp.id_logradouro = l.id ";
        
        

        CEPS = jdbcTemplate.queryForList(sql);

        return CEPS;
    }

    public List<Map<String, Object>> getSANGUE() {

        String sql = "SELECT s.descricao AS tipo_sangue FROM tipo_sanguineo s ";
        

        SANGUES = jdbcTemplate.queryForList(sql);

        return SANGUES;
    }

    public List<Map<String, Object>> getCIVIL() {

        String sql = "SELECT c.descricao AS civil FROM estado_civil c ";
        

        CIVIL = jdbcTemplate.queryForList(sql);

        return CIVIL;
    }

    public void atualizarPessoa(int id_gerado) {
        
        String sql = "UPDATE Pessoa SET id_nome = ?, id_genero = ?, id_data_nascimento = ?, id_email = ?, id_celular = ?, id_complemento = ? WHERE id = ?";

        jdbcTemplate.update(sql, id_gerado, id_gerado, id_gerado, id_gerado, id_gerado, id_gerado);

    }
    

}
