package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import rh.enums.Escolaridade;

@Entity
public class Dependentes extends EntityId{
    @Column
    private String nome;
    @Column
    private Escolaridade escolaridade;
    @Column
    private String dataNascimento;

    public Dependentes(String nome, Escolaridade escolaridade, String dataNascimento) {
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

    @Override
    public String toString() {
        return "Dependentes{" +
                "nome='" + nome + '\'' +
                ", escolaridade=" + escolaridade +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
