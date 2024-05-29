package com.rh.financeiro.service;

public class ExperienciaAnteriorService {

    @Autowired
    private ExperienciaAnteriorRepository ExperienciaAnteriorRepository;

    public ExperienciaAnterior salvar(ExperienciaAnterior entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return ExperienciaAnteriorRepository.save(entity);
    }

    public List<ExperienciaAnterior> buscaTodos(){
        return ExperienciaAnteriorRepository.findAll();
    }
    public ExperienciaAnterior buscaPorId(Long id){
        return ExperienciaAnteriorRepository.findById(id).orElse(null);
    }

    public ExperienciaAnterior alterar(Long id, ExperienciaAnterior alterado){
        Optional<ExperienciaAnterior> encontrado = ExperienciaAnteriorRepository.findById(id);
        if (encontrado.isPresent()){
            ExperienciaAnterior ExperienciaAnterior = encontrado.get();


            return ExperienciaAnteriorRepository.save(ExperienciaAnterior);
        }
        return null;
    }
    public void remover(Long id) {
        ExperienciaAnteriorRepository.deleteById(id);
    }
}