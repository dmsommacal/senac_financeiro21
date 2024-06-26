package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Filiacao extends EntityId{
    @Column
    private String nomePai;
    @Column
    private String telefonePai;
    @Column
    private String nomeMae;
    @Column
    private String telefoneMae;

    public Filiacao() {
        this.nomePai = nomePai;
        this.telefonePai = telefonePai;
        this.nomeMae = nomeMae;
        this.telefoneMae = telefoneMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getTelefonePai() {
        return telefonePai;
    }

    public void setTelefonePai(String telefonePai) {
        this.telefonePai = telefonePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTelefoneMae() {
        return telefoneMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        this.telefoneMae = telefoneMae;
    }

    @Override
    public String toString() {
        return "Filiacao{" +
                "nomePai='" + nomePai + '\'' +
                ", telefonePai='" + telefonePai + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", telefoneMae='" + telefoneMae + '\'' +
                '}';
    }
}
