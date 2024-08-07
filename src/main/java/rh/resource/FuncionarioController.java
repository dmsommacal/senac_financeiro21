package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Funcionario;
import rh.repository.FuncionarioRepository;
import rh.resource.dto.FuncionarioDTO;
import rh.service.FuncionarioService;
import org.springframework.data.domain.Pageable;
@RestController
@RequestMapping("/api/funcionarios")

public class FuncionarioController extends AbstractController{

    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private FuncionarioService service;
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioDTO.toEntity();
        service.salvar(funcionario);
        return ResponseEntity.ok(FuncionarioDTO.fromEntity(funcionario));
    }
    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(required = false)String cpf,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10  ")int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Funcionario> funcionariosPage;
        if (cpf != null && !cpf.isEmpty()) {
            funcionariosPage = repository.findByCpf(cpf, pageable);
        } else if (filter != null && !filter.isEmpty()) {
            funcionariosPage = repository.findByNome(filter, pageable);
        } else {
            funcionariosPage = repository.findAll(pageable);
        }

        Page<FuncionarioDTO> funcionariosDTOPage = funcionariosPage.map(FuncionarioDTO::fromEntity);
        return ResponseEntity.ok(funcionariosDTOPage);
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Funcionario funcionario = service.buscaPorId(id);
        return ResponseEntity.ok(FuncionarioDTO.fromEntity(funcionario));
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
