package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.*;
import rh.model.Specification.Specification;
import rh.model.Specification.ValidationResult;
import rh.model.Specification.EntradaSpecification;
import org.springframework.data.domain.Pageable;
import rh.repository.EntradaRepository;
import rh.resource.dto.EntradaDTO;
import rh.service.EntradaService;

import java.net.URI;


@RestController
@RequestMapping("/api/entradas")
public class EntradaController extends AbstractController{

    @Autowired
    private EntradaRepository repository;
    @Autowired
    private EntradaService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Entrada entity) {
        Entrada entrada = new Entrada();

        Specification<Entrada> valorSpec = new EntradaSpecification();

        ValidationResult result = valorSpec.isSatisfiedBy(entity);

        if (result.isValid()) {
            System.out.println("Entrada válida");
            Entrada save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/entradas/" + entity.getId())).body(save);
        }
        else {
            System.out.println("Entrada inválida: " + result.getMessage());
            return ResponseEntity.badRequest().body(result.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Entrada> entradasPage = repository.findAll(filter, Entrada.class, pageable);
        Page<EntradaDTO> entradasDTOPage = entradasPage.map(EntradaDTO::fromEntity);
        return ResponseEntity.ok(entradasDTOPage);
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Entrada entrada = service.buscaPorId(id);
        return ResponseEntity.ok(entrada);
    }
}
