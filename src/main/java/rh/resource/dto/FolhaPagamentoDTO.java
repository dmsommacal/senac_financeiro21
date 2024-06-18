package rh.resource.dto;

import jakarta.persistence.Column;
import rh.model.Cargo;
import rh.model.FolhaPagamento;

import java.util.ArrayList;
import java.util.List;

public class FolhaPagamentoDTO {

   private Double horaTrabalhada;
   private Double inss;
   private Double irrf;
   private Double fgts;

    public FolhaPagamentoDTO() {
    }

    public FolhaPagamentoDTO(Double horaTrabalhada, Double inss, Double irrf, Double fgts) {
        this.horaTrabalhada = horaTrabalhada;
        this.inss = inss;
        this.irrf = irrf;
        this.fgts = fgts;
    }

    public Double getHoraTrabalhada() {
        return horaTrabalhada;
    }

    public void setHoraTrabalhada(Double horaTrabalhada) {
        this.horaTrabalhada = horaTrabalhada;
    }

    public Double getInss() {
        return inss;
    }

    public void setInss(Double inss) {
        this.inss = inss;
    }

    public Double getIrrf() {
        return irrf;
    }

    public void setIrrf(Double irrf) {
        this.irrf = irrf;
    }

    public Double getFgts() {
        return fgts;
    }

    public void setFgts(Double fgts) {
        this.fgts = fgts;
    }

    public static FolhaPagamentoDTO fromEntity(FolhaPagamento folhaPagamento) {
        return new FolhaPagamentoDTO(
                folhaPagamento. getHoraTrabalhada(),
                folhaPagamento.getInss(),
                folhaPagamento.getFgts(),
                folhaPagamento.getIrrf()
        );
    }

    public static List<FolhaPagamentoDTO> fromEntityList(List<FolhaPagamento> folhaPagamentos){
        List<FolhaPagamentoDTO> folhaPagamentoDTOList = new ArrayList<>();
        for (FolhaPagamento folhaPagamento : folhaPagamentos){
            folhaPagamentoDTOList.add(fromEntity(folhaPagamento));
        }
        return folhaPagamentoDTOList;
    }

    public FolhaPagamento toEntity() {
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.setHoraTrabalhada(this.horaTrabalhada);
        folhaPagamento.setInss(this.inss);
        folhaPagamento.setIrrf(this.irrf);
        folhaPagamento.setFgts(this.fgts);
        return folhaPagamento;
    }

    public static List<FolhaPagamento> toEntityList(List<FolhaPagamentoDTO> folhaPagamentoDTOS){
        List<FolhaPagamento> folhaPagamentos = new ArrayList<>();
        for (FolhaPagamentoDTO folhaPagamentoDTO: folhaPagamentoDTOS){
            folhaPagamentos.add(folhaPagamentoDTO.toEntity());
        }
        return folhaPagamentos;
    }



}
