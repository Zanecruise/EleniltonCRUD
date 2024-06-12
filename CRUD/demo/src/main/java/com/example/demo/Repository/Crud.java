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

    private static List<Map<String, Object>> GENERO;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Crud(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void inserir(String name, String birthdate, String phone, String email, String lotNumber, String complement, int sangue, int civil, int gender, int cep) {

        String sql = "INSERT INTO Pessoa (nome, data_nascimento, celular, email, numero_residencia, complemento, id_tipo_sanguineo, id_estado_civil, id_genero, id_cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, name, birthdate, phone, email, lotNumber, complement, sangue, civil, gender, cep);

    }

    @Override
    public void atualizar(String name, String birthdate, String phone, String email, String lotNumber, String complement, int sangue, int civil, int gender, int cep,int id) {
        
        String sql = "UPDATE Pessoa SET nome = ?, data_nascimento = ?, celular = ?, email = ?, numero_residencia = ?, complemento = ?, id_tipo_sanguineo = ?, id_estado_civil = ?, id_genero = ?, id_cep = ? WHERE id = ?";

        jdbcTemplate.update(sql, name, birthdate, phone, email, lotNumber, complement, sangue, civil, gender, cep, id);

    }

    @Override
    public void excluir(int id) {
        
        String sql = "DELETE FROM Pessoa WHERE id = ? ";

        
        jdbcTemplate.update(sql, id);
    }

    public List<Map<String, Object>> getPessoas() {

            String sql = " SELECT p.id AS id_pessoa, ps.descricao AS pais, e.descricao AS estado, c.descricao AS cidade, b.descricao AS bairro, l.descricao AS logradouro, cp.descricao AS cep, p.complemento AS complemento, p.numero_residencia AS numero, p.nome, p.data_nascimento, gn.descricao AS genero , p.celular, p.email, ts.descricao AS tipo_sanguineo, ec.descricao AS estado_civil FROM pais ps " +
                       " JOIN estado e ON e.id_pais = ps.id " +
                       " JOIN cidade c ON c.id_estado = e.id " +
                       " JOIN bairro b ON b.id_cidade = c.id " +
                       " JOIN logradouro l ON l.id_bairro = b.id " +
                       " JOIN cep cp ON cp.id_logradouro = l.id " +
                       " JOIN pessoa p ON p.id_cep = cp.id " +
                       " JOIN tipo_sanguineo ts ON ts.id = p.id_tipo_sanguineo " +
                       " JOIN estado_civil ec ON ec.id = p.id_estado_civil " +
                       " JOIN genero gn ON gn.id = p.id_genero " ;

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

    public List<Map<String, Object>> getGENERO() {

        String sql = "SELECT g.descricao AS genero FROM genero g ";
        

        GENERO = jdbcTemplate.queryForList(sql);

        return GENERO;
    }

    
    

}
