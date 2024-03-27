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
    private FuncionarioRepository funcionarioRepository;
    @PostMapping
    public ResponseEntity create(@RequestBody Funcionario entity) {
        funcionarioRepository.save(entity);
        return ResponseEntity.ok().body(entity);
    }
    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        return ResponseEntity.ok().body(funcionarioRepository.findAll());
    }
}

