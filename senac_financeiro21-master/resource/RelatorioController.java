package com.rh.financeiro.resource;

import com.rh.financeiro.model.Relatorio;
import com.rh.financeiro.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

    @RestController

    @RequestMapping("/api/relatorios")
    public class RelatorioController {

        @Autowired
        private RelatorioService service;

        @PostMapping
        public ResponseEntity create(@RequestBody Relatorio entity) {
            Relatorio save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/relatorios/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll() {
            List<Relatorio> descricao = service.buscaTodos();
            return ResponseEntity.ok(descricao);
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            Relatorio descricao = service.buscaPorId(id);
            return ResponseEntity.ok(descricao);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Relatorio entity) {
            Relatorio alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
}
