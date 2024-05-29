package com.rh.financeiro.resource;

import com.rh.financeiro.model.FolhaPagamento;
import com.rh.financeiro.model.Funcionario;
import com.rh.financeiro.repository.FuncionarioRepository;
import com.rh.financeiro.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/folhaPagamentos")


public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody FolhaPagamento entity) {
        FolhaPagamento save = service.salvar(entity);
        return RespnseEntity.created(URI.create("/api/folhaPagamentos/" + entity.getId())).body(save);
    }


    @GetMapping
    public ResponseEntity findAll() {
        List<FolhaPagamento> folha = service.buscaTodos();
        return ResponseEntity.ok(folha);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        FolhaPagamento folha = service.buscaPorId(id);
        return ResponseEntity.ok(folha);
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