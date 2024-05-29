package com.rh.financeiro.service;

import com.rh.financeiro.enterprise.ValidationException;
import com.rh.financeiro.model.Funcionario;
import com.rh.financeiro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Funcionario> buscaTodos(){
        return funcionarioRepository.findAll();
    }
    public Funcionario buscaPorId(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario alterar(Long id, Funcionario alterado){
        Optional<Funcionario> encontrado = funcionarioRepository.findById(id);
        if (encontrado.isPresent()){
            Funcionario funcionario = encontrado.get();

            funcionario.setAreaAtuacao(alterado.getAreaAtuacao());
            funcionario.setCargo(alterado.getCargo());
            funcionario.setCargaHoraria(alterado.getCargaHoraria());
            funcionario.setEmail(alterado.getEmail());
            funcionario.setDoadorSangue(alterado.getDoadorSangue());
            funcionario.setEndereco(alterado.getEndereco());
            funcionario.setEstadoCivil(alterado.getEstadoCivil());
            funcionario.setFonePessoal(alterado.getFonePessoal());
            funcionario.setFoneRecados(alterado.getFoneRecados());
            funcionario.setSetor(alterado.getSetor());
            funcionario.setStatus(alterado.getStatus());
            funcionario.setRedeSocial(alterado.getRedeSocial());
            funcionario.setHoraEntrada(alterado.getHoraEntrada());
            funcionario.setHoraSaida(alterado.getHoraSaida());
            funcionario.setHoraExtra(alterado.getHoraExtra());
            funcionario.setGenero(alterado.getGenero());
            funcionario.setIdiomas(alterado.getIdiomas());

            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
