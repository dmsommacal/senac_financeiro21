package rh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rh.enums.Escolaridade;
@Entity
public class Dependente extends EntityId{
    @Column
    private String nome;
    @Column
    private Escolaridade escolaridade;
    @Column
    private String dataNascimento;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Dependente() {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
        this.funcionario = funcionario;
    }

    public Dependente(String nome, Escolaridade escolaridade, String dataNascimento, Funcionario funcionario) {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
        this.funcionario = funcionario;
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

    @Override
    public String toString() {
        return "Dependente{" +
                "nome='" + nome + '\'' +
                ", escolaridade=" + escolaridade +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }

    public static class Builder {
        private String nome;
        private Escolaridade escolaridade;
        private String dataNascimento;
        private Funcionario funcionario;

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
            builder.funcionario = dependente.funcionario;
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
        public Builder funcionario(Funcionario funcionario){
            this.funcionario = funcionario;
            return this;
        }

        public Dependente builder(){
            return new Dependente(nome, escolaridade, dataNascimento, funcionario);
        }
    }
}
