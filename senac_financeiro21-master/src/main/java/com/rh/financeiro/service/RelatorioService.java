package com.rh.financeiro.service;

public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public Relatorio salvar(Relatorio entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return relatorioRepository.save(entity);
    }

    public List<Relatorio> buscaTodos(){
        return relatorioRepository.findAll();
    }
    public Relatorio buscaPorId(Long id){
        return relatorioRepository.findById(id).orElse(null);
    }

    public Relatorio alterar(Long id, Relatorio alterado){
        Optional<Relatorio> encontrado = relatorioRepository.findById(id);
        if (encontrado.isPresent()){
            Relatorio relatorio = encontrado.get();


            return relatorioRepository.save(relatorio);
        }
        return null;
    }
    public void remover(Long id) {
        relatorioRepository.deleteById(id);
    }
}