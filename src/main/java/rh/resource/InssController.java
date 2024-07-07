package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Inss;
import rh.repository.InssRepository;
import rh.service.InssService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/inss")
public class InssController {
    @Autowired
    private InssRepository repository;
    @Autowired
    private InssService service;
    @PostMapping
    public ResponseEntity create(@RequestBody Inss entity) {
        Inss inss1 = new Inss(7.5, 0.0);
        Inss inss2 = new Inss(9.0, 21.18);
        Inss inss3 = new Inss(12.0, 101.18);
        Inss inss4 = new Inss(14.0, 181.18);

        this.repository.save(inss1);
        this.repository.save(inss2);
        this.repository.save(inss3);
        this.repository.save(inss4);

        Inss save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/inss/" + entity.getId())).body(save);
    }
    @GetMapping
    public ResponseEntity findAll(){
        List<Inss> inss = service.buscaTodos();
        return ResponseEntity.ok(inss);
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Inss inss = service.buscaPorId(id);
        return ResponseEntity.ok(inss);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Inss entity) {
        Inss alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
