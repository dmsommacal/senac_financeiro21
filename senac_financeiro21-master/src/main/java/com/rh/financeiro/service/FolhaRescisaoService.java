package com.rh.financeiro.service;

public class FolhaRescisaoService {

    @Autowired
    private FolhaRescicaoRepository FolhaRescicaoRepository;

    public FolhaRescicao salvar(FolhaRescicao entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return FolhaRescicaoRepository.save(entity);
    }

    public List<FolhaRescicao> buscaTodos(){
        return FolhaRescicaoRepository.findAll();
    }
    public FolhaRescicao buscaPorId(Long id){
        return FolhaRescicaoRepository.findById(id).orElse(null);
    }

    public FolhaRescicaoRepository alterar(Long id, FolhaRescicaoRepository alterado){
        Optional<FolhaRescicaoRepository> encontrado = FolhaRescicaoRepository.findById(id);
        if (encontrado.isPresent()){
            FolhaRescicaoRepository funcionario = encontrado.get();


            return FolhaRescicaoRepository.save(FolhaRescicao);
        }
        return null;
    }
    public void remover(Long id) {
        FolhaRescicaoRepository.deleteById(id);
    }
}