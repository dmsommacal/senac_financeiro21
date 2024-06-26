package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import rh.model.Relatorio;
import rh.repository.RelatorioRepository;
import rh.resource.dto.RelatorioDTO;
import rh.service.RelatorioService;

import java.net.URI;

@RestController
@RequestMapping("/api/relatorios")


public class RelatorioController extends AbstractController{

    @Autowired
    private RelatorioRepository repository;
    @Autowired
    private RelatorioService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Relatorio entity) {
        Relatorio save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/relatorios/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Relatorio> relatoriosPage = repository.findAll(filter, Relatorio.class, pageable);
        Page<RelatorioDTO> relatoriosDTOPage = relatoriosPage.map(RelatorioDTO::fromEntity);
        return ResponseEntity.ok(relatoriosDTOPage);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Relatorio relatorio = service.buscaPorId(id);
        return ResponseEntity.ok(relatorio);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Relatorio entity) {
        Relatorio alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
