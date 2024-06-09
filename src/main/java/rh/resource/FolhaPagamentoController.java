package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.FolhaPagamento;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/folhasPagamentos")


public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody FolhaPagamento entity) {
        FolhaPagamento save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/folhasPagamentos/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<FolhaPagamento> folhaPagamento = service.buscaTodos();
        return ResponseEntity.ok(folhaPagamento);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        FolhaPagamento folhaPagamento = service.buscaPorId(id);
        return ResponseEntity.ok(folhaPagamento);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody FolhaPagamento entity) {
        FolhaPagamento folhaPagamento = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
