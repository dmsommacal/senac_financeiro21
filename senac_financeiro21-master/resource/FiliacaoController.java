package com.rh.financeiro.resource;

import com.rh.financeiro.model.Filiacao;
import com.rh.financeiro.service.FiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/filiacoes")

public class FiliacaoController {

    @Autowired
    private FiliacaoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Filiacao entity) {
        Filiacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/filiacoes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Filiacao> pais = service.buscaTodos();
        return ResponseEntity.ok(pais);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Filiacao pais = service.buscaPorId(id);
        return ResponseEntity.ok(pais);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Filiacao entity) {
        Filiacao alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}