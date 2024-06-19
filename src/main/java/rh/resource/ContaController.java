package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Conta;
import rh.resource.dto.ContaDTO;
import rh.service.ContaService;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController extends AbstractController{

    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity findAll() {
        List<Conta> contas = service.buscaTodos();
        return ResponseEntity.ok(ContaDTO.fromEntityList(contas));
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Conta conta = service.buscaPorId(id);
        return ResponseEntity.ok(conta);
    }

}
