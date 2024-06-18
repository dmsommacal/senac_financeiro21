package rh.resource.dto;

import rh.model.ExperienciaAnterior;
import rh.model.FolhaRescisao;

import java.util.ArrayList;
import java.util.List;

public class FolhaRescisaoDTO {

    private Double valorRescisao;

    public FolhaRescisaoDTO() {
    }

    public FolhaRescisaoDTO(Double valorRescisao) {
        this.valorRescisao = valorRescisao;
    }

    public Double getValorRescisao() {
        return valorRescisao;
    }

    public void setValorRescisao(Double valorRescisao) {
        this.valorRescisao = valorRescisao;
    }

    public static FolhaRescisaoDTO fromEntity(FolhaRescisao folhaRescisao) {
        return new FolhaRescisaoDTO(
                folhaRescisao.getValorRescisao()
        );
    }

    public static List<FolhaRescisaoDTO> fromEntityList(List<FolhaRescisao> folhaRescisaos) {
        List<FolhaRescisaoDTO> folhaRescisaoDTOList = new ArrayList<>();
        for (FolhaRescisao folhaRescisao : folhaRescisaos) {
            folhaRescisaoDTOList.add(fromEntity(folhaRescisao));
        }
        return folhaRescisaoDTOList;
    }

    public FolhaRescisao toEntity() {
        FolhaRescisao folhaRescisao = new FolhaRescisao();
        folhaRescisao.setValorRescisao(this.valorRescisao);
        return folhaRescisao;
    }

    public static List<FolhaRescisao> toEntityList(List<FolhaRescisaoDTO> folhaRescisaoDTOS) {
        List<FolhaRescisao> folhaRescisaos = new ArrayList<>();
        for (FolhaRescisaoDTO folhaRescisaoDTO : folhaRescisaoDTOS) {
            folhaRescisaos.add(folhaRescisaoDTO.toEntity());
        }
        return folhaRescisaos;
    }
}