package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Solicitacao;
import rh.model.Specification.SolicitacaoSpecification;
import rh.model.Specification.Specification;
import rh.model.Specification.ValidationResult;
import rh.repository.SolicitacaoRepository;
import org.springframework.data.domain.Pageable;
import rh.resource.dto.SolicitacaoDTO;
import rh.service.SolicitacaoService;

import java.net.URI;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoController extends AbstractController{

    @Autowired
    private SolicitacaoRepository repository;
    @Autowired
    private SolicitacaoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Solicitacao entity) {
        Solicitacao solicitacao = new Solicitacao();

        Specification<Solicitacao> valorSolicitadoSpec = new SolicitacaoSpecification();

        ValidationResult result = valorSolicitadoSpec.isSatisfiedBy(entity);

        if (result.isValid()) {
            System.out.println("Solicitação válida");
            Solicitacao save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/entradas/" + entity.getId())).body(save);
        }
        else {
            System.out.println("Solicitação inválida: " + result.getMessage());
            return ResponseEntity.badRequest().body(result.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Solicitacao> solicitacoesPage = repository.findAll(filter, Solicitacao.class, pageable);
        Page<SolicitacaoDTO> solicitacoesDTOPage = solicitacoesPage.map(SolicitacaoDTO::fromEntity);
        return ResponseEntity.ok(solicitacoesDTOPage);
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
