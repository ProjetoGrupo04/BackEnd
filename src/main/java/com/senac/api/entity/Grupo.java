package com.senac.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grupo_id")
	private Long id;
	@Column(name = "grupo_descricao")
	private String descricao;
	@Column(name = "grupo_inicio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate inicio = LocalDate.now();
	@Column(name = "grupo_fim")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fim = LocalDate.now();
	@Column(name = "grupo_sala")
	private String sala;
	@Column(name = "grupo_status")
	private Boolean status;
	@OneToOne
	@JoinColumn(name = "turno_id", referencedColumnName = "turno_id")
	private Turno turnoId;
	@ManyToOne
	@JoinColumn(name = "unidade_curricular_id", referencedColumnName = "unidade_curricular_id")
	private UnidadeCurricular unidadeCurricularId;
	@OneToOne
	@JoinColumn(name = "periodo_id", referencedColumnName = "periodo_id")
	private Periodo periodoId;
	@OneToOne
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id")
	private Professor professorId;
	@JsonIgnore
	@OneToMany(mappedBy = "grupoId")
	private List<Participante> participantes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Turno getTurnoId() {
		return turnoId;
	}
	public void setTurnoId(Turno turnoId) {
		this.turnoId = turnoId;
	}
	public UnidadeCurricular getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(UnidadeCurricular unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	public Periodo getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Periodo periodoId) {
		this.periodoId = periodoId;
	}
	public Professor getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Professor professorId) {
		this.professorId = professorId;
	}
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
		
}
