package com.rh.financeiro.service;

public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada salvar(Entrada entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return entradaRepository.save(entity);
    }

    public List<Entrada> buscaTodos(){
        return entradaRepository.findAll();
    }
    public Entrada buscaPorId(Long id){
        return entradaRepository.findById(id).orElse(null);
    }

    public Entrada alterar(Long id, Entrada alterado){
        Optional<Entrada> encontrado = entradaRepository.findById(id);
        if (encontrado.isPresent()){
            Entrada entrada = encontrado.get();


            return entradaRepository.save(entrada);
        }
        return null;
    }
    public void remover(Long id) {
        entradaRepository.deleteById(id);
    }
}