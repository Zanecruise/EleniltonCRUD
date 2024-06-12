package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import com.example.demo.Repository.Crud;

// FUNÇÕES CHAMADAS PELO JAVASCRIPT
@RestController
public class GetCrontroller {

     private final Crud crud;

    @Autowired
    public GetCrontroller(Crud crud) {
        this.crud = crud;
    }

    @GetMapping("/chamarFuncaoJava")
    public List<Map<String, Object>> chamarFuncaoJava() {
        
        return crud.getPessoas();
    }

    @GetMapping("/chamarCEP")
    public List<Map<String, Object>> chamarCEP() {
        
        return crud.getCEPS();
    }

    @GetMapping("/chamarSANGUE")
    public List<Map<String, Object>> chamarSANGUE() {
        
        return crud.getSANGUE();
    }

    @GetMapping("/chamarCIVIL")
    public List<Map<String, Object>> chamarCIVIL() {
        
        return crud.getCIVIL();
    }

    @GetMapping("/chamarGENERO")
    public List<Map<String, Object>> chamarGENERO() {
        
        return crud.getGENERO();
    }

    @GetMapping("/excluirPessoa")
    public ResponseEntity<Void> excluirPessoa(@RequestParam int id) {

        crud.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    

    
}
