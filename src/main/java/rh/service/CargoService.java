package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Cargo;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public Cargo salvar(Cargo entity){
        if (entity.getDescricao().isBlank()){
            throw new ValidationException("A descrição não pode estar vazia.");
        }
        return cargoRepository.save(entity);
    }

    public List<Cargo> buscaTodos(){
        return cargoRepository.findAll();
    }
    public Cargo buscaPorId(Long id){
        return cargoRepository.findById(id).orElse(null);
    }

    public Cargo alterar(Long id, Cargo alterado){
        Optional<Cargo> encontrado = cargoRepository.findById(id);
        if (encontrado.isPresent()){
            Cargo cargo = encontrado.get();
            return cargoRepository.save(cargo);
        }
        return null;
    }
    public void remover(Long id) {
        cargoRepository.deleteById(id);
    }
}