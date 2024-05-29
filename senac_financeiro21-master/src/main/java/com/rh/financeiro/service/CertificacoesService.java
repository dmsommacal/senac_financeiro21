package com.rh.financeiro.service;

public class CertificacoesService {

    @Autowired
    private CertificacoesRepository certificacoesRepository;

    public Certificacoes salvar(Certificacoes entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return certificacoesRepository.save(entity);
    }

    public List<Certificacoes> buscaTodos(){
        return certificacoesRepository.findAll();
    }
    public Certificacoes buscaPorId(Long id){
        return certificacoesRepository.findById(id).orElse(null);
    }

    public Certificacoes alterar(Long id, Certificacoes alterado){
        Optional<Certificacoes> encontrado = certificacoesRepository.findById(id);
        if (encontrado.isPresent()){
            Certificacoes certificacoes = encontrado.get();



            return certificacoesRepository.save(certificacoes);
        }
        return null;
    }
    public void remover(Long id) {
        certificacoesRepository.deleteById(id);
    }
}