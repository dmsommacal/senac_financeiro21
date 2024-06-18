package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.*;
import rh.model.Specification.Specification;
import rh.model.Specification.ValidationResult;
import rh.model.Specification.ValorSpecification;
import rh.resource.dto.EntradaDTO;
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

        Specification<Entrada> valorSpec = new ValorSpecification();

        ValidationResult result = valorSpec.isSatisfiedBy(entity);

        if (result.isValid()){
            System.out.println("Entrada válida");
        }
        else {
            System.out.println("Entrada inválida: " + result.getMessage());
        }
        Entrada save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/entradas/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Entrada> entradas = service.buscaTodos();
        return ResponseEntity.ok(EntradaDTO.fromEntityList(entradas));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Entrada entrada = service.buscaPorId(id);
        return ResponseEntity.ok(entrada);
    }
}
