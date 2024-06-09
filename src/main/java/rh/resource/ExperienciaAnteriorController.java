package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.ExperienciaAnterior;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/experienciaAnteriores")


public class ExperienciaAnteriorController {

    @Autowired
    private ExperienciaAnteriorService service;


    @PostMapping
    public ResponseEntity create(@RequestBody ExperienciaAnterior entity) {
        ExperienciaAnterior save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/experienciaAnteriores/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<ExperienciaAnterior> experienciaAnteriores = service.buscaTodos();
        return ResponseEntity.ok(experienciaAnteriores);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        ExperienciaAnterior experienciaAnterior = service.buscaPorId(id);
        return ResponseEntity.ok(experienciaAnterior);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ExperienciaAnterior entity) {
        ExperienciaAnterior experienciaAnterior = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}