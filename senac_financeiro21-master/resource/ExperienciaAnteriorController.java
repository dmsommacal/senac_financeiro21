package com.rh.financeiro.resource;

import com.rh.financeiro.model.ExperienciaAnterior;
import com.rh.financeiro.service.ExperienciaAnteriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
        import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaAnteriorController {

    @Autowired
    private ExperienciaAnteriorService service;

    @PostMapping
    public ResponseEntity create(@RequestBody ExperienciaAnterior entity) {
        ExperienciaAnterior save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/experiencias/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<ExperienciaAnterior> curriculo = service.buscaTodos();
        return ResponseEntity.ok(curriculo);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        ExperienciaAnterior curriculo = service.buscaPorId(id);
        return ResponseEntity.ok(curriculo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ExperienciaAnterior entity) {
        ExperienciaAnterior alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}