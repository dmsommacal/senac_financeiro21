package rh.resource.dto;
import rh.model.DadoBancario;
import rh.model.ExperienciaAnterior;
import rh.model.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExperienciaAnteriorDTO {

    private Funcionario funcionario;

    private String descricao;

    private String cargo;

    private LocalDate periodoInicial;

    private LocalDate periodoFinal;

    public ExperienciaAnteriorDTO() {
    }

    public ExperienciaAnteriorDTO(Funcionario funcionario, String descricao, String cargo, LocalDate periodoInicial, LocalDate periodoFinal) {
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.cargo = cargo;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(LocalDate periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }
    public static ExperienciaAnteriorDTO fromEntity(ExperienciaAnterior experienciaAnterior) {
        return new ExperienciaAnteriorDTO(
                experienciaAnterior.getFuncionario(),
                experienciaAnterior.getDescricao(),
                experienciaAnterior.getCargo(),
                experienciaAnterior.getPeriodoInicial(),
                experienciaAnterior.getPeriodoFinal()
        );
    }
    public static List<ExperienciaAnteriorDTO> fromEntityList(List<ExperienciaAnterior> experienciaAnteriors){
        List<ExperienciaAnteriorDTO> experienciaAnteriorDTOList = new ArrayList<>();
        for (ExperienciaAnterior experienciaAnterior : experienciaAnteriors){
            experienciaAnteriorDTOList.add(fromEntity(experienciaAnterior));
        }
        return experienciaAnteriorDTOList;
    }
    public ExperienciaAnterior toEntity() {
        ExperienciaAnterior experienciaAnterior = new ExperienciaAnterior();
        experienciaAnterior.setFuncionario(this.funcionario);
        experienciaAnterior.setDescricao(this.descricao);
        experienciaAnterior.setCargo(this.cargo);
        experienciaAnterior.setPeriodoInicial(this.periodoInicial);
        experienciaAnterior.setPeriodoFinal(this.periodoInicial);
        return experienciaAnterior;
    }
    public static List<ExperienciaAnterior> toEntityList(List<ExperienciaAnteriorDTO> experienciaAnteriorDTOS){
        List<ExperienciaAnterior> experienciaAnteriors = new ArrayList<>();
        for (ExperienciaAnteriorDTO experienciaAnteriorDTO : experienciaAnteriorDTOS){
            experienciaAnteriors.add(experienciaAnteriorDTO.toEntity());
        }
        return experienciaAnteriors;
    }
}
