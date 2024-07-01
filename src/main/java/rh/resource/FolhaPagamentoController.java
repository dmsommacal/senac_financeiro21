package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import rh.model.FolhaPagamento;
import rh.repository.FolhaPagamentoRepository;
import rh.resource.dto.FolhaPagamentoDTO;
import rh.service.FolhaPagamentoService;

import java.net.URI;

@RestController
@RequestMapping("/api/folhas-pagamentos")


public class FolhaPagamentoController extends AbstractController{

    @Autowired
    private FolhaPagamentoRepository repository;
    @Autowired
    private FolhaPagamentoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody FolhaPagamento entity) {
        FolhaPagamento save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/folhas-pagamentos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<FolhaPagamento> folhaPagamentosPage = repository.findAll(filter, FolhaPagamento.class, pageable);
        Page<FolhaPagamentoDTO> folhaPagamentosDTOPage = folhaPagamentosPage.map(FolhaPagamentoDTO::fromEntity);
        return ResponseEntity.ok(folhaPagamentosDTOPage);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        FolhaPagamento folhaPagamento = service.buscaPorId(id);
        return ResponseEntity.ok(folhaPagamento);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody FolhaPagamento entity) {
        FolhaPagamento alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
