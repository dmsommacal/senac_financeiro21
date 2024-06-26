package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.ExperienciaAnterior;
import rh.repository.ExperienciaAnteriorRepository;
import org.springframework.data.domain.Pageable;
import rh.resource.dto.ExperienciaAnteriorDTO;
import rh.service.ExperienciaAnteriorService;

import java.net.URI;

@RestController
@RequestMapping("/api/experiencias-anteriores")


public class ExperienciaAnteriorController extends AbstractController{

    @Autowired
    private ExperienciaAnteriorRepository repository;
    @Autowired
    private ExperienciaAnteriorService service;


    @PostMapping
    public ResponseEntity create(@RequestBody ExperienciaAnterior entity) {
        ExperienciaAnterior save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/experiencias-anteriores/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<ExperienciaAnterior> experienciaAnterioresPage = repository.findAll(filter, ExperienciaAnterior.class, pageable);
        Page<ExperienciaAnteriorDTO> experienciaAnterioresDTOPage = experienciaAnterioresPage.map(ExperienciaAnteriorDTO::fromEntity);
        return ResponseEntity.ok(experienciaAnterioresDTOPage);
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
        ExperienciaAnterior alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
