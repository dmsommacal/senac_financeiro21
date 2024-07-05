package rh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import rh.enums.ModalidadeContratual;
import rh.enums.Turno;

import java.util.List;

@Entity
public class Cargo extends EntityId {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;
    @Column
    private Integer codigo;
    @Column
    private String descricao;
    @Column
    private String nivel;
    private Turno turno;
    private ModalidadeContratual modalidadeContratual;

    public Cargo() {
        this.funcionarios = funcionarios;
        this.descricao = descricao;
        this.nivel = nivel;
        this.turno = turno;
        this.modalidadeContratual = modalidadeContratual;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public ModalidadeContratual getModalidadeContratual() {
        return modalidadeContratual;
    }

    public void setModalidadeContratual(ModalidadeContratual modalidadeContratual) {
        this.modalidadeContratual = modalidadeContratual;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "funcionarios=" + funcionarios + ", descricao='" + descricao + '\'' +
                ", nivel='" + nivel + '\'' +
                ", turno=" + turno +
                ", modalidadeContratual=" + modalidadeContratual +
                '}';
    }
}