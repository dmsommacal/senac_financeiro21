package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Cargo;
import rh.model.Funcionario;
import rh.repository.FuncionarioRepository;
import rh.resource.dto.FuncionarioDTO;
import rh.service.FuncionarioService;
import org.springframework.data.domain.Pageable;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/funcionarios")


public class FuncionarioController extends AbstractController{

    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private FuncionarioService service;
    @PostMapping
    public ResponseEntity create(@RequestBody Funcionario entity) {
        Funcionario save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/funcionarios/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Funcionario> funcionariosPage = repository.findAll(filter, Funcionario.class, pageable);
        Page<FuncionarioDTO> funcionariosDTOPage = funcionariosPage.map(FuncionarioDTO::fromEntity);
        return ResponseEntity.ok(funcionariosDTOPage);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id,
                                   @PathVariable("id") String nome,
                                   @PathVariable("id") String cpf
    ) {
        Funcionario funcionario = service.buscaPorId(id);
        return ResponseEntity.ok(funcionario);
    }
    @GetMapping("{nome}")
    public ResponseEntity findByNome(@RequestParam String nome) {
        List<Funcionario> funcionarios = service.buscaPorNome(nome);
        if (!funcionarios.isEmpty()) {
            return ResponseEntity.ok(funcionarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Funcionario entity) {
        Funcionario alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
