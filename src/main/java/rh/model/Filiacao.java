package rh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Filiacao() {
        this.nomePai = nomePai;
        this.telefonePai = telefonePai;
        this.nomeMae = nomeMae;
        this.telefoneMae = telefoneMae;
        this.funcionario = funcionario;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    @Override
    public String toString() {
        return "Filiacao{" +
                "nomePai='" + nomePai + '\'' +
                ", telefonePai='" + telefonePai + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", telefoneMae='" + telefoneMae + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }
}
