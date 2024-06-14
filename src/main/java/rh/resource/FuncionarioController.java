package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Funcionario;
import rh.service.FuncionarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")


public class FuncionarioController extends AbstractController{

    @Autowired
    private FuncionarioService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Funcionario entity) {
        Funcionario save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/funcionarios/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<Funcionario> funcionarios = service.buscaTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Funcionario funcionario = service.buscaPorId(id);
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
