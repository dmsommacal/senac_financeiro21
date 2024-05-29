package com.rh.financeiro.service;

public class DadosBancariosService {

    @Autowired
    private DadosBancariosRepository DadosBancariosRepository;

    public DadosBancarios salvar(DadosBancarios entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return dadosBancariosRepository.save(entity);
    }

    public List<DadosBancarios> buscaTodos(){
        return dadosBancariosRepository.findAll();
    }
    public DadosBancarios buscaPorId(Long id){
        return dadosBancariosRepository.findById(id).orElse(null);
    }

    public DadosBancarios alterar(Long id, DadosBancarios alterado){
        Optional<DadosBancarios> encontrado = dadosBancariosRepository.findById(id);
        if (encontrado.isPresent()){
            DadosBancarios dadosBancarios = encontrado.get();



            return funcionarioRepository.save(dadosBancarios);
        }
        return null;
    }
    public void remover(Long id) {
        dadosBancariosRepository.deleteById(id);
    }
}