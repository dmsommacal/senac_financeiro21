package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Certificacao;
import rh.resource.dto.CertificacaoDTO;
import rh.service.CertificacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/certificacoes")


public class CertificacaoController extends AbstractController{

    @Autowired
    private CertificacaoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Certificacao entity) {
        Certificacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/certificacoes/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<Certificacao> certificacoes = service.buscaTodos();
        return ResponseEntity.ok(CertificacaoDTO.fromEntityList(certificacoes));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Certificacao certificacoes = service.buscaPorId(id);
        return ResponseEntity.ok(certificacoes);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Certificacao entity) {
        Certificacao alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
