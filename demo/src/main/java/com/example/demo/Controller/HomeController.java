package com.example.demo.Controller;

import com.example.demo.Service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PessoaService pessoaService;

    // Corrigido o nome do construtor para HomeController
    public HomeController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/") // principal.html
    public String principal() {
        return "principal"; 
    }

    @GetMapping("/criar-pessoa") // formulario.html
    public String criarPessoa() {
        return "formulario";
    }

    @GetMapping("/listar-pessoas")
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaService.buscarTodasPessoas());
        return "listagem-pessoas";
    }
}
