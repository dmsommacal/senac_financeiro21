package com.rh.financeiro.service;

import com.rh.financeiro.enterprise.ValidationException;
import com.rh.financeiro.model.Funcionario;
import com.rh.financeiro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Funcionario> buscaTodos(){
        return funcionarioRepository.findAll();
    }
    public Funcionario buscaPorId(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }
    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
