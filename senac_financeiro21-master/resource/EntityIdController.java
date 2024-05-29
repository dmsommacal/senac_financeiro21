package com.rh.financeiro.resource;

import com.rh.financeiro.model.EntityId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController

@RequestMapping("/api/entityId")
public class EntityIdController {

    @Autowired
    private EntityIdService service;

    @PostMapping
    public ResponseEntity create(@RequestBody EntityId entity) {
        EntityId save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/entityId/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<EntityId> identifica = service.buscaTodos();
        return ResponseEntity.ok(identifica);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        EntityId identifica = service.buscaPorId(id);
        return ResponseEntity.ok(identifica);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody EntityId entity) {
        EntityId alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}