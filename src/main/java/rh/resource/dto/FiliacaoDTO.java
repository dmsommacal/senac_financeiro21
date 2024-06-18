package rh.resource.dto;

import rh.model.Cargo;
import rh.model.Filiacao;

import java.util.ArrayList;
import java.util.List;

public class FiliacaoDTO {

    private String nomePai;
    private String telefonePai;
    private String nomeMae;
    private String telefoneMae;

    public FiliacaoDTO() {
    }

    public FiliacaoDTO(String nomePai, String telefonePai, String nomeMae, String telefoneMae) {
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
    public static FiliacaoDTO fromEntity(Filiacao filiacao) {
        return new FiliacaoDTO(
                filiacao.getNomePai(),
                filiacao.getTelefonePai(),
                filiacao.getNomeMae(),
                filiacao.getTelefoneMae()
        );
    }
    public static List<FiliacaoDTO> fromEntityList(List<Filiacao> filiacoes){
        List<FiliacaoDTO> filiacaoDTOList = new ArrayList<>();
        for (Filiacao filiacao : filiacoes){
            filiacaoDTOList.add(fromEntity(filiacao));
        }
        return filiacaoDTOList;
    }
    public Filiacao toEntity() {
        Filiacao filiacao = new Filiacao();
        filiacao.setNomePai(this.nomePai);
        filiacao.setTelefonePai(this.telefonePai);
        filiacao.setNomeMae(this.nomeMae);
        filiacao.setTelefoneMae(this.telefoneMae);
        return filiacao;
    }
    public static List<Filiacao> toEntityList(List<FiliacaoDTO> filiacaoDTOs){
        List<Filiacao> filiacoes = new ArrayList<>();
        for (FiliacaoDTO filiacaoDTO : filiacaoDTOs){
            filiacoes.add(filiacaoDTO.toEntity());
        }
        return filiacoes;
    }
}
