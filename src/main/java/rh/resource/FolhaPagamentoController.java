package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.FolhaPagamento;
import rh.resource.dto.FolhaPagamentoDTO;
import rh.service.FolhaPagamentoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/folhas-pagamentos")


public class FolhaPagamentoController extends AbstractController{

    @Autowired
    private FolhaPagamentoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody FolhaPagamento entity) {
        FolhaPagamento save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/folhas-pagamentos/" + entity.getId())).body(save);
    }

    @GetMapping

    public ResponseEntity findAll() {
        List<FolhaPagamento> folhaPagamentos = service.buscaTodos();
        return ResponseEntity.ok(FolhaPagamentoDTO.fromEntityList(folhaPagamentos));
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
