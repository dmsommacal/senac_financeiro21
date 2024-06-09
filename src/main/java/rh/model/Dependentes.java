package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import rh.enums.Escolaridade;

@Entity
public class Dependentes extends EntityId{
    @Column
    private String Nome;
    @Column
    private Escolaridade escolaridade;
    @Column
    private String DataNascimento;

    public Dependentes(String nome, Escolaridade escolaridade, String dataNascimento) {
        Nome = nome;
        this.escolaridade = escolaridade;
        DataNascimento = dataNascimento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Dependentes{" +
                "Nome='" + Nome + '\'' +
                ", escolaridade=" + escolaridade +
                ", DataNascimento='" + DataNascimento + '\'' +
                '}';
    }
}
