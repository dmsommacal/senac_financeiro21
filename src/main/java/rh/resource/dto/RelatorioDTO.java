package rh.resource.dto;

import rh.model.Entrada;
import rh.model.Relatorio;
import rh.model.Solicitacao;

import java.util.ArrayList;
import java.util.List;

public class RelatorioDTO {
    private List<Entrada> entradas;
    private List<Solicitacao> solicitacoes;
    private Double relDemonstrativo;

    public RelatorioDTO() {
    }

    public RelatorioDTO(List<Entrada> entradas, List<Solicitacao> solicitacoes, Double relDemonstrativo) {
        this.entradas = entradas;
        this.solicitacoes = solicitacoes;
        this.relDemonstrativo = relDemonstrativo;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public Double getRelDemonstrativo() {
        return relDemonstrativo;
    }

    public void setRelDemonstrativo(Double relDemonstrativo) {
        this.relDemonstrativo = relDemonstrativo;
    }

    public static RelatorioDTO fromEntity(Relatorio relatorio) {
        return new RelatorioDTO(
                relatorio.getEntradas(),
                relatorio.getSolicitacoes(),
                relatorio.getRelDemonstrativo()
        );
    }

    public static List<RelatorioDTO> fromEntityList(List<Relatorio> relatorios){
        List<RelatorioDTO> relatorioDTOList = new ArrayList<>();
        for (Relatorio relatorio : relatorios){
            relatorioDTOList.add(fromEntity(relatorio));
        }
        return relatorioDTOList;
    }
    public Relatorio toEntity() {
        Relatorio relatorio = new Relatorio();
        relatorio.setEntradas(this.entradas);
        relatorio.setSolicitacoes(this.solicitacoes);
        relatorio.setRelDemonstrativo(this.relDemonstrativo);
        return relatorio;
    }
    public static List<Relatorio> toEntityList(List<RelatorioDTO> relatorioDTOS){
        List<Relatorio> relatorios = new ArrayList<>();
        for (RelatorioDTO relatorioDTO : relatorioDTOS){
            relatorios.add(relatorioDTO.toEntity());
        }
        return relatorios;
    }

}
