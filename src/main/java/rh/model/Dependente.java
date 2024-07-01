package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import rh.enums.Escolaridade;

@Entity
public class Dependente extends EntityId{
    @Column
    private String nome;
    @Column
    private Escolaridade escolaridade;
    @Column
    private String dataNascimento;

    public Dependente() {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
    }

    public Dependente(String nome, Escolaridade escolaridade, String dataNascimento) {
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

    public static class Builder {
        private String nome;
        private Escolaridade escolaridade;
        private String dataNascimento;

        private Builder(){
        }

        public static Builder create(){
            return new Builder();
        }

        public static Builder from (Dependente dependente){
            Builder builder = new Builder();
            builder.nome = dependente.nome;
            builder.escolaridade = dependente.escolaridade;
            builder.dataNascimento = dependente.dataNascimento;
            return builder;
        }

        public  Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder escolaridade(Escolaridade escolaridade){
            this.escolaridade = escolaridade;
            return this;
        }

        public Builder dataNascimento(String dataNascimento){
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Dependente builder(){
            return new Dependente(nome, escolaridade, dataNascimento);
        }
    }
}
