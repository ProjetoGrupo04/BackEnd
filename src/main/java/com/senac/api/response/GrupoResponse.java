package com.senac.api.response;

import java.time.LocalDate;

import com.senac.api.entity.Periodo;
import com.senac.api.entity.Professor;
import com.senac.api.entity.Turno;
import com.senac.api.entity.UnidadeCurricular;

public class GrupoResponse{

	private Long id;
	private String descricao;
	private LocalDate inicio = LocalDate.now();
	private LocalDate fim = LocalDate.now();
	private String sala;
	private Boolean status;
	private Turno turnoId;
	private UnidadeCurricular unidadeCurricularId;
	private Periodo periodoId;
	private Professor professorId;
	
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
	
}
