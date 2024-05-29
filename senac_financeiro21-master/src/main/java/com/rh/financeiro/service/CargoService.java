package com.rh.financeiro.service;

import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired
    private CargoRepository funcionarioRepository;

    public Cargo salvar(Cargo entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return cargoRepository.save(entity);
    }

    public List<Cargo> buscaTodos(){
        return CargoRepository.findAll();
    }
    public Cargo buscaPorId(Long id){
        return cargoRepository.findById(id).orElse(null);
    }

    public Cargo alterar(Long id, Cargo alterado){
        Optional<Cargo> encontrado = cargoRepository.findById(id);
        if (encontrado.isPresent()){



            return cargoRepository.save(cargo);
        }
        return null;
    }
    public void remover(Long id) {
        cargoRepository.deleteById(id);
    }
}