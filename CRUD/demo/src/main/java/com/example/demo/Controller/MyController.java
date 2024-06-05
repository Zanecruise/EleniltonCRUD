package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.Crud;

// FUNÇÕES CHAMADAS PELO JAVASCRIPT
@RestController
public class MyController {

     private final Crud crud;

    @Autowired
    public MyController(Crud crud) {
        this.crud = crud;
    }

    @GetMapping("/chamarFuncaoJava")
    public List<Map<String, Object>> chamarFuncaoJava() {
        // Chame sua função Java aqui
        
        return crud.getPessoas();
    }

    @GetMapping("/chamarCEP")
    public List<Map<String, Object>> chamarCEP() {
        // Chame sua função Java aqui
        
        return crud.getCEPS();
    }

    @GetMapping("/chamarSANGUE")
    public List<Map<String, Object>> chamarSANGUE() {
        // Chame sua função Java aqui
        
        return crud.getSANGUE();
    }

    @GetMapping("/chamarCIVIL")
    public List<Map<String, Object>> chamarCIVIL() {
        // Chame sua função Java aqui
        
        return crud.getCIVIL();
    }

    

    
}
