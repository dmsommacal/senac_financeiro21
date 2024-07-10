package rh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import rh.enums.Escolaridade;
import rh.enums.EstadoCivil;
import rh.enums.Genero;
import rh.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Funcionario extends EntityId{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<FolhaPagamento> folhasPagamentos;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "funcionario")
    private List<ExperienciaAnterior> experienciasAnteriores;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Certificacao> certificacoes;
    private Escolaridade escolaridade;
    private EstadoCivil estadoCivil;
    private Genero genero;
    private Status status;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToOne
//    @JoinColumn(name = "cargo_id")
//    private Cargo cargo;
    @Column
    private String cargo;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String rg;
    @Column
    private String endereco;
    @Column
    private String ctps;
    @Column
    private BigDecimal salarioContratual;
    @Column
    private Integer cargaHoraria;
    @Column
    private String fonePessoal;
    @Column
    private String foneRecados;
    @Column
    private String titulo;
    @Column
    private String carteiraReservista;
    @Column
    private LocalDate dataNascimento;
    @Column
    private String pis;
    @Column
    private String registroProfissional;
    @Column
    private String email;
    @Column
    private String sindicato;
    @Column
    private String setor;
    @Column
    private String cnh;
    @Column
    private LocalDate dataAdmissao;
    @Column
    private String racaCor;
    @Column
    private String religiao;
    @Column
    private Boolean doadorSangue;
    @Column
    private String nacionalidade;
    @Column
    private String redeSocial;
    @Column
    private String areaAtuacao;
    @Column
    private String matricula;
    @Column
    private String idiomas;
    @Column
    private Integer horaExtra;
    @Column
    private LocalTime horaEntrada;
    @Column
    private LocalTime horaSaida;

    public Funcionario() {
    }

    public Funcionario(List<FolhaPagamento> folhasPagamentos, List<ExperienciaAnterior> experienciasAnteriores, List<Certificacao> certificacoes, Escolaridade escolaridade, EstadoCivil estadoCivil, Genero genero, Status status,String cargo, String nome, String cpf, String rg, String endereco, String ctps, BigDecimal salarioContratual, Integer cargaHoraria, String fonePessoal, String foneRecados, String titulo, String carteiraReservista, LocalDate dataNascimento, String pis, String registroProfissional, String email, String sindicato, String setor, String cnh, LocalDate dataAdmissao, String racaCor, String religiao, Boolean doadorSangue, String nacionalidade, String redeSocial, String areaAtuacao, String matricula, String idiomas, Integer horaExtra, LocalTime horaEntrada, LocalTime horaSaida) {
        this.folhasPagamentos = folhasPagamentos;
        this.experienciasAnteriores = experienciasAnteriores;
        this.certificacoes = certificacoes;
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.status = status;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.ctps = ctps;
        this.salarioContratual = salarioContratual;
        this.cargaHoraria = cargaHoraria;
        this.fonePessoal = fonePessoal;
        this.foneRecados = foneRecados;
        this.titulo = titulo;
        this.carteiraReservista = carteiraReservista;
        this.dataNascimento = dataNascimento;
        this.pis = pis;
        this.registroProfissional = registroProfissional;
        this.email = email;
        this.sindicato = sindicato;
        this.setor = setor;
        this.cnh = cnh;
        this.dataAdmissao = dataAdmissao;
        this.racaCor = racaCor;
        this.religiao = religiao;
        this.doadorSangue = doadorSangue;
        this.nacionalidade = nacionalidade;
        this.redeSocial = redeSocial;
        this.areaAtuacao = areaAtuacao;
        this.matricula = matricula;
        this.idiomas = idiomas;
        this.horaExtra = horaExtra;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public List<FolhaPagamento> getFolhasPagamentos() {
        return folhasPagamentos;
    }

    public void setFolhasPagamentos(List<FolhaPagamento> folhasPagamentos) {
        this.folhasPagamentos = folhasPagamentos;
    }

    public List<ExperienciaAnterior> getExperienciasAnteriores() {
        return experienciasAnteriores;
    }

    public void setExperienciasAnteriores(List<ExperienciaAnterior> experienciasAnteriores) {
        this.experienciasAnteriores = experienciasAnteriores;
    }

    public List<Certificacao> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<Certificacao> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    //    public Cargo getCargo() {
//        return cargo;
//    }
//
//    public void setCargo(Cargo cargo) {
//        this.cargo = cargo;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public BigDecimal getSalarioContratual() {
        return salarioContratual;
    }

    public void setSalarioContratual(BigDecimal salarioContratual) {
        this.salarioContratual = salarioContratual;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getFonePessoal() {
        return fonePessoal;
    }

    public void setFonePessoal(String fonePessoal) {
        this.fonePessoal = fonePessoal;
    }

    public String getFoneRecados() {
        return foneRecados;
    }

    public void setFoneRecados(String foneRecados) {
        this.foneRecados = foneRecados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCarteiraReservista() {
        return carteiraReservista;
    }

    public void setCarteiraReservista(String carteiraReservista) {
        this.carteiraReservista = carteiraReservista;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public Boolean getDoadorSangue() {
        return doadorSangue;
    }

    public void setDoadorSangue(Boolean doadorSangue) {
        this.doadorSangue = doadorSangue;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(Integer horaExtra) {
        this.horaExtra = horaExtra;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "folhasPagamentos=" + folhasPagamentos +
                ", experienciasAnteriores=" + experienciasAnteriores +
                ", certificacoes=" + certificacoes +
                ", escolaridade=" + escolaridade +
                ", estadoCivil=" + estadoCivil +
                ", genero=" + genero +
                ", status=" + status +
                ", cargo='" + cargo + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", endereco='" + endereco + '\'' +
                ", ctps='" + ctps + '\'' +
                ", salarioContratual=" + salarioContratual +
                ", cargaHoraria=" + cargaHoraria +
                ", fonePessoal='" + fonePessoal + '\'' +
                ", foneRecados='" + foneRecados + '\'' +
                ", titulo='" + titulo + '\'' +
                ", carteiraReservista='" + carteiraReservista + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", pis='" + pis + '\'' +
                ", registroProfissional='" + registroProfissional + '\'' +
                ", email='" + email + '\'' +
                ", sindicato='" + sindicato + '\'' +
                ", setor='" + setor + '\'' +
                ", cnh='" + cnh + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", racaCor='" + racaCor + '\'' +
                ", religiao='" + religiao + '\'' +
                ", doadorSangue=" + doadorSangue +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", redeSocial='" + redeSocial + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                ", matricula='" + matricula + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", horaExtra=" + horaExtra +
                ", horaEntrada=" + horaEntrada +
                ", horaSaida=" + horaSaida +
                '}';
    }
}
