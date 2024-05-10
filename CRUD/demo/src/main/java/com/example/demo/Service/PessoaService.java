package com.example.demo.Service;

import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> buscarTodasPessoas() {
        return pessoaRepository.findAll();
    }
    
    // Outros métodos da classe PessoaService
}
