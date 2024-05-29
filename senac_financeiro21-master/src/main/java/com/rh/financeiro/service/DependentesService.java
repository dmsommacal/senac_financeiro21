package com.rh.financeiro.service;

public class DependentesService {

    @Autowired
    private DependentesRepository dependentesRepository;

    public Dependentes salvar(Dependentes entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return dependentesRepository.save(entity);
    }

    public List<Dependentes> buscaTodos(){
        return dependentesRepository.findAll();
    }
    public Dependentes buscaPorId(Long id){
        return dependentesRepository.findById(id).orElse(null);
    }

    public Dependentes alterar(Long id, Dependentes alterado){
        Optional<Dependentes> encontrado = dependentesRepository.findById(id);
        if (encontrado.isPresent()){
            Dependentes dependentes = encontrado.get();


            return dependentesRepository.save(dependentes);
        }
        return null;
    }
    public void remover(Long id) {
        dependentesRepository.deleteById(id);
    }
}