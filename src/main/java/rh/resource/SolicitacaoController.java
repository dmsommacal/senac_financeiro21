package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Solicitacao;
import rh.service.SolicitacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/solicitacoes")


public class SolicitacaoController extends AbstractController{

    @Autowired
    private SolicitacaoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Solicitacao entity) {
        Solicitacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/solicitacoes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Solicitacao> solicitacao = service.buscaTodos();
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Solicitacao solicitacao = service.buscaPorId(id);
        return ResponseEntity.ok(solicitacao);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Solicitacao entity) {
        Solicitacao alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
