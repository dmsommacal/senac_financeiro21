package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class FolhaPagamento extends EntityId{
    @Column
    private Double hrtrabalhada;
    @Column
    private Double INSS;
    @Column
    private Double IRRF;
    @Column
    private Double FGTS;

    public FolhaPagamento(Double hrtrabalhada, Double INSS, Double IRRF, Double FGTS) {
        this.hrtrabalhada = hrtrabalhada;
        this.INSS = INSS;
        this.IRRF = IRRF;
        this.FGTS = FGTS;
    }

    public Double getHrtrabalhada() {
        return hrtrabalhada;
    }

    public void setHrtrabalhada(Double hrtrabalhada) {
        this.hrtrabalhada = hrtrabalhada;
    }

    public Double getINSS() {
        return INSS;
    }

    public void setINSS(Double INSS) {
        this.INSS = INSS;
    }

    public Double getIRRF() {
        return IRRF;
    }

    public void setIRRF(Double IRRF) {
        this.IRRF = IRRF;
    }

    public Double getFGTS() {
        return FGTS;
    }

    public void setFGTS(Double FGTS) {
        this.FGTS = FGTS;
    }

    @Override
    public String toString() {
        return "FolhaPagamento{" +
                "hrtrabalhada=" + hrtrabalhada +
                ", INSS=" + INSS +
                ", IRRF=" + IRRF +
                ", FGTS=" + FGTS +
                '}';
    }
}