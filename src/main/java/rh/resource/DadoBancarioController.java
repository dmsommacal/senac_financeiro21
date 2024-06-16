package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.DadoBancario;
import rh.service.DadoBancarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/dados-bancarios")


public class DadoBancarioController extends AbstractController{

    @Autowired
    private DadoBancarioService service;


    @PostMapping
    public ResponseEntity create(@RequestBody DadoBancario entity) {
        DadoBancario save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/dados-bancarios/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<DadoBancario> dadosBancarios = service.buscaTodos();
        return ResponseEntity.ok(dadosBancarios);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        DadoBancario dadoBancario = service.buscaPorId(id);
        return ResponseEntity.ok(dadoBancario);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody DadoBancario entity) {
        DadoBancario alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
