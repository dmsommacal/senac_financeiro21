package rh.resource.dto;

import rh.enums.Escolaridade;
import rh.model.Dependente;
import rh.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DependenteDTO {
    private Long id;
    private String nome;
    private Escolaridade escolaridade;
    private String dataNascimento;
    private Funcionario funcionario;

    public DependenteDTO() {
    }
    public DependenteDTO(Long id, String nome, Escolaridade escolaridade, String dataNascimento, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public static DependenteDTO fromEntity(Dependente dependente) {
        return new DependenteDTO(
                dependente.getId(),
                dependente.getNome(),
                dependente.getEscolaridade(),
                dependente.getDataNascimento(),
                dependente.getFuncionario()
        );
    }
    public static List<DependenteDTO> fromEntityList(List<Dependente> dependentes){
        List<DependenteDTO> dependenteDTOList = new ArrayList<>();
        for (Dependente dependente : dependentes){
            dependenteDTOList.add(fromEntity(dependente));
        }
        return dependenteDTOList;
    }
    public Dependente toEntity() {
        Dependente dependente = new Dependente();
        dependente.setId(this.id);
        dependente.setNome(this.nome);
        dependente.setEscolaridade(this.escolaridade);
        dependente.setDataNascimento(this.dataNascimento);
        dependente.setFuncionario(this.funcionario);
        return dependente;
    }
    public static List<Dependente> toEntityList(List<DependenteDTO> dependenteDTOs){
        List<Dependente> dependentes = new ArrayList<>();
        for (DependenteDTO dependenteDTO : dependenteDTOs){
            dependentes.add(dependenteDTO.toEntity());
        }
        return dependentes;
    }
}
