package rh.resource.dto;

import rh.enums.ModalidadeContratual;
import rh.enums.Turno;
import rh.model.Cargo;
import rh.model.Funcionario;

import java.util.ArrayList;
import java.util.List;
public class CargoDTO {
    private List<Funcionario> funcionarios;
    private String descricao;
    private String nivel;
    private Turno turno;
    private ModalidadeContratual modalidadeContratual;

    public CargoDTO() {
    }

    public CargoDTO(List<Funcionario> funcionarios, String descricao, String nivel, Turno turno, ModalidadeContratual modalidadeContratual) {
        this.funcionarios = funcionarios;
        this.descricao = descricao;
        this.nivel = nivel;
        this.turno = turno;
        this.modalidadeContratual = modalidadeContratual;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public ModalidadeContratual getModalidadeContratual() {
        return modalidadeContratual;
    }

    public void setModalidadeContratual(ModalidadeContratual modalidadeContratual) {
        this.modalidadeContratual = modalidadeContratual;
    }
    public static CargoDTO fromEntity(Cargo cargo) {
        return new CargoDTO(
                cargo.getFuncionarios(),
                cargo.getDescricao(),
                cargo.getNivel(),
                cargo.getTurno(),
                cargo.getModalidadeContratual()
        );
    }
    public static List<CargoDTO> fromEntityList(List<Cargo> cargos){
        List<CargoDTO> cargoDTOList = new ArrayList<>();
        for (Cargo cargo : cargos){
            cargoDTOList.add(fromEntity(cargo));
        }
        return cargoDTOList;
    }
    public Cargo toEntity() {
        Cargo cargo = new Cargo();
        cargo.setFuncionarios(this.funcionarios);
        cargo.setDescricao(this.descricao);
        cargo.setNivel(this.nivel);
        cargo.setTurno(this.turno);
        cargo.setModalidadeContratual(this.modalidadeContratual);
        return cargo;
    }
    public static List<Cargo> toEntityList(List<CargoDTO> cargoDTOs){
        List<Cargo> cargos = new ArrayList<>();
        for (CargoDTO cargoDTO : cargoDTOs){
            cargos.add(cargoDTO.toEntity());
        }
        return cargos;
    }
}

