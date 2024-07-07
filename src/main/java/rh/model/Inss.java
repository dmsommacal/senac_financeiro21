package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Inss extends EntityId{
    @Column
    private Double aliquota;
    @Column
    private Double parcelaDeducao;
    public Inss(Double aliquota, Double parcelaDeducao) {
        this.aliquota = aliquota;
        this.parcelaDeducao = parcelaDeducao;
    }

    public Double getAliquota() {
        return aliquota;
    }

    public void setAliquota(Double aliquota) {
        this.aliquota = aliquota;
    }

    public Double getParcelaDeducao() {
        return parcelaDeducao;
    }

    public void setParcelaDeducao(Double parcelaDeducao) {
        this.parcelaDeducao = parcelaDeducao;
    }

    @Override
    public String toString() {
        return "Inss{" +
                "aliquota=" + aliquota +
                ", parcelaDeducao=" + parcelaDeducao +
                '}';
    }
}
