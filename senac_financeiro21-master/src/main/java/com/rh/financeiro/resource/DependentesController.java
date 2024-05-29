package com.rh.financeiro.resource;

import com.rh.financeiro.model.Dependentes;
import com.rh.financeiro.service.DependentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/dependentes")
public class DependentesController {

    @Autowired
    private DependentesService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Dependentes entity) {
        Dependentes save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/dependentes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Dependentes> filiacoes = service.buscaTodos();
        return ResponseEntity.ok(filiacoes);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Dependentes filiacoes = service.buscaPorId(id);
        return ResponseEntity.ok(filiacoes);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Dependentes entity) {
        Dependentes alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}