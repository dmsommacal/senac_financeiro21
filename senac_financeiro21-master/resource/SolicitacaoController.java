package com.rh.financeiro.resource;

import com.rh.financeiro.model.Solicitacao;
import com.rh.financeiro.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

    @RestController
    @RequestMapping("/api/solicitacoes")
    public class SolicitacaoController {

        @Autowired
        private SolicitacaoService service;

        @PostMapping
        public ResponseEntity create(@RequestBody Solicitacao entity) {
            Solicitacao save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/solicitacoes/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll() {
            List<Solicitacao> pedido = service.buscaTodos();
            return ResponseEntity.ok(pedido);
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            Solicitacao pedido = service.buscaPorId(id);
            return ResponseEntity.ok(pedido);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Solicitacao entity) {
            Solicitacao alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
    }