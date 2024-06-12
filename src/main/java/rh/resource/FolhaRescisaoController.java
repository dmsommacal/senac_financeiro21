package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.FolhaRescisao;
import rh.service.FolhaRescisaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/folhas-recisoes")


public class FolhaRescisaoController {

    @Autowired
    private FolhaRescisaoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody FolhaRescisao entity) {
        FolhaRescisao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/folhas-recisoes/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<FolhaRescisao> folhaRescisao = service.buscaTodos();
        return ResponseEntity.ok(folhaRescisao);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        FolhaRescisao folhaRescisao = service.buscaPorId(id);
        return ResponseEntity.ok(folhaRescisao);
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