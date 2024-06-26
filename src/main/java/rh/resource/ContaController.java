package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Conta;
import rh.repository.ContaRepository;
import org.springframework.data.domain.Pageable;
import rh.resource.dto.ContaDTO;
import rh.service.ContaService;


@RestController
@RequestMapping("/api/contas")
public class ContaController extends AbstractController{

    @Autowired
    private ContaRepository repository;
    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Conta> contasPage = repository.findAll(filter, Conta.class, pageable);
        Page<ContaDTO> contasDTOPage = contasPage.map(ContaDTO::fromEntity);
        return ResponseEntity.ok(contasDTOPage);
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Conta conta = service.buscaPorId(id);
        return ResponseEntity.ok(conta);
    }

}
