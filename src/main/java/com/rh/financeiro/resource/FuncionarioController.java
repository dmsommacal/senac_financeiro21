package com.rh.financeiro.resource;

import com.rh.financeiro.model.Funcionario;
import com.rh.financeiro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")

public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repository;
    @PostMapping
    public ResponseEntity create(@RequestBody Funcionario entity) {
        repository.save(entity);
        return ResponseEntity.ok().body(entity);
    }
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(findAll());
    }

}

