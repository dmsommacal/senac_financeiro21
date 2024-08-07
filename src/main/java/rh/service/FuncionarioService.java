package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Funcionario;
import rh.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public Funcionario salvar(Funcionario entity){
        if (entity.getNome().length()<3 || entity.getNome().isBlank()){
            throw new ValidationException("O nome deve ter mais que 3 caracteres e não pode ser nulo");
        }
        return funcionarioRepository.save(entity);
    }
    public List<Funcionario> buscaTodos() {
        return funcionarioRepository.findAll();
    }
    public Funcionario buscaPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }
    public Funcionario alterar(Long id, Funcionario alterado){
        Optional<Funcionario> encontrado = funcionarioRepository.findById(id);
        if (encontrado.isPresent()){
            Funcionario funcionario = encontrado.get();

            funcionario.setNome(alterado.getNome());
            funcionario.setCpf(alterado.getCpf());
            funcionario.setRg(alterado.getRg());
            funcionario.setCargo(alterado.getCargo());
            funcionario.setEmail(alterado.getEmail());
            funcionario.setFonePessoal(alterado.getFonePessoal());
            funcionario.setFoneRecados(alterado.getFoneRecados());

            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }
}