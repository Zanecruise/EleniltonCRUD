package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.Repository.Crud;


// FUNCOES PARA FAZER O CRUD
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
                                
                                @RequestParam("relation") int civil,
                                @RequestParam("blood") int sangue,  
                                @RequestParam("cep") int cep,

                                @RequestParam("lot_number") String lotNumber,
                                @RequestParam("complement") String complement) {
        
        crud.inserirPessoa(name, birthdate, gender, sangue, civil, phone, email);

        int id_gerado = crud.getIDNome(name);  

        crud.inserirEndereco(complement, lotNumber, id_gerado, cep);
       

        return "redirect:/";
    }

    @PostMapping("/processFormEdit")
    public String processFormEdit(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("birthdate") String birthdate,
                                    @RequestParam("gender") String gender,
                                    
                                    @RequestParam("relationNUM") int civil,
                                    @RequestParam("bloodNUM") int sangue,  
                                    @RequestParam("cepNUM") int cep,

                                    @RequestParam("lot_number") String lotNumber,
                                    @RequestParam("complement") String complement) {
                                
        int id_gerado = crud.getIDNome(name);          

        crud.atualizar("Nome", name,id_gerado);
        crud.atualizar("Email", email,id_gerado);
        crud.atualizar("Celular", phone,id_gerado);
        crud.atualizar("Data_nascimento", birthdate,id_gerado);
        crud.atualizar("Genero", gender,id_gerado);

        

        crud.atualizarPessoa(id_gerado);
                           

        return "redirect:/";
    }

    // Outros métodos do controlador, se houver

}
