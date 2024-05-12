package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.Repository.Crud;

@Controller
public class SeuController {

    private final Crud crud;

    @Autowired
    public SeuController(Crud crud) {
        this.crud = crud;
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


                                

        crud.inserir("Nome", name,0);

        int id_gerado = crud.getIDNome(name);

        crud.inserir("Email", email,0);
        crud.inserir("Celular", phone,0);
        crud.inserir("Data_nascimento", birthdate,0);
        crud.inserir("Genero", gender,0);

        crud.inserir("Pais", country,0);

        crud.inserir("Complemento", complement,0);

        crud.inserirEstado(state, id_gerado);
        crud.inserirCidade(city, id_gerado);
        crud.inserirRua(street, id_gerado);
        crud.inserirBairro(neighborhood, id_gerado);
        crud.inserirNumeroLote(lotNumber, id_gerado);
        
        crud.inserirEndereco(id_gerado);
        crud.inserirPessoa(id_gerado);

        

        return "redirect:/";
    }

    // Outros métodos do controlador, se houver

}
