package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.*;
import rh.service.EntradaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController extends AbstractController{

    @Autowired
    private EntradaService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Entrada entity) {

        Entrada entrada = new Entrada();
        Specification<Entrada> entradaSpec = new EntradaSpecification();

        Specification<Entrada> validEntradaSpec = entradaSpec.and(entradaSpec);

        ValidationResult result = validEntradaSpec.isSatisfiedBy(entrada);
        if (result.isValid()){
            System.out.println("Entrada válida");
        }
        else{
            System.out.println("Enrada inválida: " + result.getMessage());
        }

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
