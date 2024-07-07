package rh.model;

import jakarta.persistence.Entity;

@Entity
public class Irrf extends Inss{
    public Irrf(Double aliquota, Double parcelaDeducao) {
        super(aliquota, parcelaDeducao);
    }
}
