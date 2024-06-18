package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Filiacao;
import rh.resource.dto.FiliacaoDTO;
import rh.service.FiliacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/filiacoes")


public class FiliacaoController extends AbstractController{

    @Autowired
    private FiliacaoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Filiacao entity) {
        Filiacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/filiacoes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Filiacao> filiacoes = service.buscaTodos();
        return ResponseEntity.ok(FiliacaoDTO.fromEntityList(filiacoes));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Filiacao filiacao = service.buscaPorId(id);
        return ResponseEntity.ok(filiacao);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Filiacao entity) {
        Filiacao alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
