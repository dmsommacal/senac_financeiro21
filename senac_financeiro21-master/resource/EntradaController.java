package com.rh.financeiro.resource;


import com.rh.financeiro.model.Entrada;
import com.rh.financeiro.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/entradas")
    public class EntradaController {

        @Autowired
        private EntradaService service;

        @PostMapping
        public ResponseEntity create(@RequestBody Entrada entity) {
            Entrada save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/entradas/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll() {
            List<Entrada> valores = service.buscaTodos();
            return ResponseEntity.ok(valores);
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            Entrada valores = service.buscaPorId(id);
            return ResponseEntity.ok(valores);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Entrada entity) {
            Entrada alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
}
