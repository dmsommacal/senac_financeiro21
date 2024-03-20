package com.rh.financeiro.model;

public class Cargo {

    private String Descricao;
    private String Nivel;
    private Boolean Comissao;
    private Turno turno;
    private ModalidadeContratual modalidadeContratual;

    public Cargo(String descricao, String nivel, Boolean comissao, Turno turno, ModalidadeContratual modalidadeContratual) {
        Descricao = descricao;
        Nivel = nivel;
        Comissao = comissao;
        this.turno = turno;
        this.modalidadeContratual = modalidadeContratual;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public Boolean getComissao() {
        return Comissao;
    }

    public void setComissao(Boolean comissao) {
        Comissao = comissao;
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
                "Descricao='" + Descricao + '\'' +
                ", Nivel='" + Nivel + '\'' +
                ", Comissao=" + Comissao +
                ", turno=" + turno +
                ", modalidadeContratual=" + modalidadeContratual +
                '}';
    }
}
