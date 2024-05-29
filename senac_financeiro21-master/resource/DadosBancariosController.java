package com.rh.financeiro.resource;
import com.rh.financeiro.model.DadosBancarios;
import com.rh.financeiro.service.DadosBancariosService;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/dadosbancarios")

public class DadosBancariosController {

        @Autowired
        private DadosBancariosService service;

        @PostMapping
        public ResponseEntity create(@RequestBody DadosBancarios entity) {
            DadosBancarios save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/dadosbancarios/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll() {
            List<DadosBancarios> dados = service.buscaTodos();
            return ResponseEntity.ok(dados);
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            DadosBancarios dados = service.buscaPorId(id);
            return ResponseEntity.ok(dados);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }
        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody DadosBancarios entity) {
            DadosBancarios alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
    }
