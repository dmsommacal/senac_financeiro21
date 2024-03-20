package com.example.finaceiro24.Model;

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
