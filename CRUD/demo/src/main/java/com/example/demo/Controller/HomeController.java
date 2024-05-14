package com.example.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// ENDPOINTS PARA PAGINAS
@Controller
public class HomeController {


    @GetMapping("/") // principal.html
    public String principal() {
        return "principal"; 
    }

    @GetMapping("/criar-pessoa") // formulario.html
    public String criarPessoa() {
        return "formulario";
    }


}
