package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Insert implements InterfaceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Insert(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void inserir(String nomeTabela, String descricao, int id) {

        String sql = "INSERT INTO " + nomeTabela + " (descricao) VALUES (?)";

        jdbcTemplate.update(sql, descricao);

    }

}
