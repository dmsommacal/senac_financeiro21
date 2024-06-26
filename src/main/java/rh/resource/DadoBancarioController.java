package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.DadoBancario;
import rh.repository.DadoBancarioRepository;
import rh.resource.dto.DadoBancarioDTO;
import rh.service.DadoBancarioService;
import org.springframework.data.domain.Pageable;

import java.net.URI;


@RestController
@RequestMapping("/api/dados-bancarios")


public class DadoBancarioController extends AbstractController{

    @Autowired
    private DadoBancarioRepository repository;
    @Autowired
    private DadoBancarioService service;


    @PostMapping
    public ResponseEntity create(@RequestBody DadoBancario entity) {
        DadoBancario save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/dados-bancarios/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<DadoBancario> dadoBancariosPage = repository.findAll(filter, DadoBancario.class, pageable);
        Page<DadoBancarioDTO> dadoBancariosDTOPage = dadoBancariosPage.map(DadoBancarioDTO::fromEntity);
        return ResponseEntity.ok(dadoBancariosDTOPage);
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
