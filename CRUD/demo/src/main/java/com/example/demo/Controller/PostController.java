package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.Crud;

@Controller
public class PostController {

    private final Crud crud;

    @Autowired
    public PostController(Crud crud) {
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

                                @RequestParam("gender") int gender,
                                @RequestParam("relation") int civil,
                                @RequestParam("blood") int sangue,  
                                @RequestParam("cep") int cep,

                                @RequestParam("lot_number") String lotNumber,
                                @RequestParam("complement") String complement) {
        
        crud.inserir(name, birthdate, phone, email, lotNumber, complement, sangue, civil, gender, cep);    

        return "redirect:/";
    }

    @PostMapping("/processFormEdit")
    public String processFormEdit(@RequestParam("nameNEW") int nameNEW, // ID
                                    @RequestParam("name") String name, // NOVO
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("birthdate") String birthdate,
     
                                    @RequestParam("genderNUM") int gender,                                    
                                    @RequestParam("relationNUM") int civil,
                                    @RequestParam("bloodNUM") int sangue,  
                                    @RequestParam("cepNUM") int cep,

                                    @RequestParam("lot_number") String lotNumber,
                                    @RequestParam("complement") String complement) {

        crud.atualizar(name, birthdate, phone, email, lotNumber, complement, sangue, civil, gender, cep, nameNEW);

        return "redirect:/";
    }

    

}
