package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Dependente;
import rh.repository.DependenteRepository;
import rh.resource.dto.DependenteDTO;
import rh.service.DependenteService;
import org.springframework.data.domain.Pageable;

import java.net.URI;

@RestController
@RequestMapping("/api/dependentes")


public class DependenteController extends AbstractController{

    @Autowired
    private DependenteRepository repository;
    @Autowired
    private DependenteService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Dependente entity) {
        Dependente save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/dependentes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Dependente> dependentesPage = repository.findAll(filter, Dependente.class, pageable);
        Page<DependenteDTO> dependentesDTOPage = dependentesPage.map(DependenteDTO::fromEntity);
        return ResponseEntity.ok(dependentesDTOPage);
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