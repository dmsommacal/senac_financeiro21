package com.rh.financeiro.resource;

import com.rh.financeiro.model.FolhaRescisao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


    @RestController
    @RequestMapping("/api/recisoes")
    public class FolhaRecisaoController {

        @Autowired
        private ParentService service;

        @PostMapping
        public ResponseEntity create(@RequestBody FolhaRescisao entity) {
            FolhaRescisao save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/recisoes/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll() {
            List<FolhaRescisao> recisao = service.buscaTodos();
            return ResponseEntity.ok(recisao);
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            FolhaRescisao recisao = service.buscaPorId(id);
            return ResponseEntity.ok(recisao);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody FolhaRescisao entity) {
            FolhaRescisao alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
    }