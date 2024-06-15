package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Entrada;
import rh.service.EntradaService;

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
        List<Entrada> entrada = service.buscaTodos();
        return ResponseEntity.ok(entrada);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Entrada entrada = service.buscaPorId(id);
        return ResponseEntity.ok(entrada);
    }
}
