package com.rh.financeiro.service;

public class FiliacaoService {

    @Autowired
    private FiliacaoRepository filiacaoRepository;

    public Filiacao salvar(Filiacao entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return filiacaoRepository.save(entity);
    }

    public List<Filiacao> buscaTodos(){
        return filiacaoRepository.findAll();
    }
    public Filiacao buscaPorId(Long id){
        return filiacaoRepository.findById(id).orElse(null);
    }

    public Filiacao alterar(Long id, Filiacao alterado){
        Optional<Filiacao> encontrado = filiacaoRepository.findById(id);
        if (encontrado.isPresent()){
            Filiacao filiacao = encontrado.get();


            return filiacaoRepository.save(filiacao);
        }
        return null;
    }
    public void remover(Long id) {
        filiacaoRepository.deleteById(id);
    }
}