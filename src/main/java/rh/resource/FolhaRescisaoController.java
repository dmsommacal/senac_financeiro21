package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import rh.model.FolhaRescisao;
import rh.repository.FolhaRescisaoRepository;
import rh.resource.dto.FolhaRescisaoDTO;
import rh.service.FolhaRescisaoService;

import java.net.URI;

@RestController
@RequestMapping("/api/folhas-recisoes")


public class FolhaRescisaoController extends AbstractController{

    @Autowired
    private FolhaRescisaoRepository repository;
    @Autowired
    private FolhaRescisaoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody FolhaRescisao entity) {
        FolhaRescisao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/folhas-recisoes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<FolhaRescisao> folhaRescisoesPage = repository.findAll(filter, FolhaRescisao.class, pageable);
        Page<FolhaRescisaoDTO> folhaRescisoesDTOPage = folhaRescisoesPage.map(FolhaRescisaoDTO::fromEntity);
        return ResponseEntity.ok(folhaRescisoesDTOPage);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        FolhaRescisao folhaRescisao = service.buscaPorId(id);
        return ResponseEntity.ok(folhaRescisao);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody FolhaRescisao entity) {
        FolhaRescisao alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}