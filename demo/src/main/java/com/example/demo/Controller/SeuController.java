package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.Repository.Insert;

@Controller
public class SeuController {

    private final Insert inserter;

    @Autowired
    public SeuController(Insert inserter) {
        this.inserter = inserter;
    }

    @RequestMapping("/form")
    public String showForm() {
        return "seuFormulario";
    }

    @PostMapping("/processForm")
    public String processForm(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("phone") String phone,
                              @RequestParam("birthdate") String birthdate,
                              @RequestParam("gender") String gender,
                              @RequestParam("country") String country,
                              @RequestParam("state") String state,
                              @RequestParam("city") String city,
                              @RequestParam("street") String street,
                              @RequestParam("neighborhood") String neighborhood,
                              @RequestParam("lot_number") String lotNumber,
                              @RequestParam("complement") String complement) {


                                

        inserter.inserir("Nome", name,0);
        inserter.inserir("Email", email,0);
        inserter.inserir("Celular", phone,0);
        inserter.inserir("Data_nascimento", birthdate,0);
        inserter.inserir("Genero", gender,0);
        inserter.inserir("Pais", country,0);
        inserter.inserir("Estado", state,0);
        inserter.inserir("Cidade", city,0);
        inserter.inserir("Rua", street,0);
        inserter.inserir("Bairro", neighborhood,0);
        inserter.inserir("Numero_Lote", lotNumber,0);
        inserter.inserir("Complemento", complement,0);

        inserter.inserir("Endereco", complement,0);
        inserter.inserir("Pessoa", complement,0);
        

        return "redirect:/";
    }

    // Outros métodos do controlador, se houver

}
