package com.rh.financeiro.service;

public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public Solicitacao salvar(Solicitacao entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return solicitacaoRepository.save(entity);
    }

    public List<Solicitacao> buscaTodos(){
        return solicitacaoRepository.findAll();
    }
    public Solicitacao buscaPorId(Long id){
        return solicitacaoRepository.findById(id).orElse(null);
    }

    public Solicitacao alterar(Long id, Solicitacao alterado){
        Optional<Solicitacao> encontrado = solicitacaoRepository.findById(id);
        if (encontrado.isPresent()){
            Solicitacao solicitacao = encontrado.get();


            return solicitacaoRepository.save(solicitacao);
        }
        return null;
    }
    public void remover(Long id) {
        solicitacaoRepository.deleteById(id);
    }
}