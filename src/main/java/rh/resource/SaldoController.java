package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Saldo;
import rh.resource.dto.SaldoDTO;
import rh.service.SaldoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/saldos")
public class SaldoController extends AbstractController{

    @Autowired
    private SaldoService service;

    @GetMapping
    public ResponseEntity findAll() {
        List<Saldo> saldos = service.buscaTodos();
        return ResponseEntity.ok(SaldoDTO.fromEntityList(saldos));
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Saldo saldo = service.buscaPorId(id);
        return ResponseEntity.ok(saldo);
    }

}
