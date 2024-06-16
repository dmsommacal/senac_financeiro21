package rh.resource.dto;

import jakarta.persistence.Column;
import rh.model.Cargo;
import rh.model.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class RelatorioDTO {
    private Double relEntrada;
   private Double relSaida;
   private Double relDemonstrativo;

    public RelatorioDTO() {
    }

    public RelatorioDTO(Double relEntrada, Double relSaida, Double relDemonstrativo) {
        this.relEntrada = relEntrada;
        this.relSaida = relSaida;
        this.relDemonstrativo = relDemonstrativo;
    }

    public Double getRelEntrada() {
        return relEntrada;
    }

    public void setRelEntrada(Double relEntrada) {
        this.relEntrada = relEntrada;
    }

    public Double getRelSaida() {
        return relSaida;
    }

    public void setRelSaida(Double relSaida) {
        this.relSaida = relSaida;
    }

    public Double getRelDemonstrativo() {
        return relDemonstrativo;
    }

    public void setRelDemonstrativo(Double relDemonstrativo) {
        this.relDemonstrativo = relDemonstrativo;
    }

    public static RelatorioDTO fromEntity(Relatorio relatorio) {
        return new RelatorioDTO(
                relatorio.getRelEntrada(),
                relatorio.getRelSaida(),
                relatorio.getRelDemosntrativo()
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
        relatorio.setRelEntrada(this.relEntrada);
        relatorio.setRelSaida(this.relSaida);
        relatorio.setRelDemosntrativo(this.relDemonstrativo);
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
