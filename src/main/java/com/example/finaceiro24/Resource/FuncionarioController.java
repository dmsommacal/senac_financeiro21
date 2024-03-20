package com.example.finaceiro24.Resource;

import com.example.finaceiro24.Model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("api/funcionario")

    public class FuncionarioController {

        @PostMapping
        public ResponseEntity create(@RequestBody Funcionario entity) {
            Funcionario save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/funcionario/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll() {
            List< Funcionario > funcionario = service.buscaTodos();
            return ResponseEntity.ok(funcionario);
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            Funcionario funcionario = service.buscarPorId(id);
            return ResponseEntity.ok(funcionario);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Funcionario entity) {
            Funcionario alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
    }

}
