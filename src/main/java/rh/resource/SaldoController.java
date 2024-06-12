package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Saldo;
import rh.service.SaldoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/saldos")
public class SaldoController {

    @Autowired
    private SaldoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Saldo entity) {
        Saldo save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/saldos/" + entity.getId())).body(save);
    }
    @GetMapping
    public ResponseEntity findAll() {
        List<Saldo> saldo = service.buscaTodos();
        return ResponseEntity.ok(saldo);
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Saldo saldo = service.buscaPorId(id);
        return ResponseEntity.ok(saldo);
    }

}
