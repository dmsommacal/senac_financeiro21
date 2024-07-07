package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.model.Irrf;
import rh.repository.IrrfRepository;
import rh.service.IrrfService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/irrfs")
public class IrrfController {
    @Autowired
    private IrrfRepository repository;
    @Autowired
    private IrrfService service;
    @PostMapping
    public ResponseEntity create(@RequestBody Irrf entity) {
        Irrf irrf = new Irrf(0.0, 0.0);
        Irrf Irrf1 = new Irrf(7.5, 158.40);
        Irrf irrf2 = new Irrf(15.0, 370.40);
        Irrf irrf3 = new Irrf(22.5, 651.73);
        Irrf irrf4 = new Irrf(27.5, 884.96);

        Irrf save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/irrfs/" + entity.getId())).body(save);
    }
    @GetMapping
    public ResponseEntity findAll(){
        List<Irrf> irrfs = service.buscaTodos();
        return ResponseEntity.ok(irrfs);
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Irrf irrf = service.buscaPorId(id);
        return ResponseEntity.ok(irrf);
    }
    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Irrf entity) {
        Irrf alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
