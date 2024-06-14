package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Dependente;
import rh.service.DependenteService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/dependentes")


public class DependenteController extends AbstractController{

    @Autowired
    private DependenteService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Dependente entity) {
        Dependente save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/dependentes/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<Dependente> dependentes = service.buscaTodos();
        return ResponseEntity.ok(dependentes);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Dependente dependente = service.buscaPorId(id);
        return ResponseEntity.ok(dependente);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Dependente entity) {
        Dependente alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}