package rh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.repository.CargoRepository;
import org.springframework.data.domain.Pageable;

import rh.resource.dto.CargoDTO;
import rh.model.Cargo;
import rh.service.CargoService;

import java.net.URI;


@RestController
@RequestMapping("/api/cargos")
public class CargoController extends AbstractController{

    @Autowired
    private CargoRepository repository;
    @Autowired
    private CargoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Cargo entity) {
        Cargo save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/cargos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false)String filter,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Cargo> cargosPage = repository.findAll(filter, Cargo.class, pageable);
        Page<CargoDTO> cargosDTOPage = cargosPage.map(CargoDTO::fromEntity);
        return ResponseEntity.ok(cargosDTOPage);
    }
        @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Cargo cargo = service.buscaPorId(id);
        return ResponseEntity.ok(cargo);
    }


    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Cargo entity) {
        Cargo alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
