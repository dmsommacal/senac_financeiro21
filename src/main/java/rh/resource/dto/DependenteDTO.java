package rh.resource.dto;

import rh.enums.Escolaridade;
import rh.model.Dependente;

import java.util.ArrayList;
import java.util.List;

public class DependenteDTO {

    private String nome;
    private Escolaridade escolaridade;
    private String dataNascimento;

    public DependenteDTO() {
    }

    public DependenteDTO(String nome, Escolaridade escolaridade, String dataNascimento) {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
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
    public static DependenteDTO fromEntity(Dependente dependente) {
        return new DependenteDTO(
                dependente.getNome(),
                dependente.getEscolaridade(),
                dependente.getDataNascimento()
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
        dependente.setNome(this.nome);
        dependente.setEscolaridade(this.escolaridade);
        dependente.setDataNascimento(this.dataNascimento);
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
