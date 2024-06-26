package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Certificacao;
import rh.repository.CertificacaoRepository;
import org.springframework.data.domain.Pageable;
import rh.resource.dto.CertificacaoDTO;
import rh.service.CertificacaoService;

import java.net.URI;

@RestController
@RequestMapping("/api/certificacoes")


public class CertificacaoController extends AbstractController{

    @Autowired
    private CertificacaoRepository repository;
    @Autowired
    private CertificacaoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Certificacao entity) {
        Certificacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/certificacoes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Certificacao> certificacoesPage = repository.findAll(filter, Certificacao.class, pageable);
        Page<CertificacaoDTO> certificacoesDTOPage = certificacoesPage.map(CertificacaoDTO::fromEntity);
        return ResponseEntity.ok(certificacoesDTOPage);
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
