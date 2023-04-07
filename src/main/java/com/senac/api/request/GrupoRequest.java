package com.senac.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class GrupoRequest{

	private Long id;
	@NotNull(message = "O campo descricao deve ser preenchido!!")
	private String descricao;
	private LocalDate inicio = LocalDate.now();
	private LocalDate fim = LocalDate.now();
	@NotNull(message = "O campo sala deve ser preenchido!!")
	private String sala;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo turno deve ser preenchido!!")
	private Long turnoId;
	@NotNull(message = "O campo unidade curricular deve ser preenchido!!")
	private Long unidadeCurricularId;
	@NotNull(message = "O campo periodo deve ser preenchido!!")
	private Long periodoId;
	@NotNull(message = "O campo professor deve ser preenchido!!")
	private Long professorId;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getTurnoId() {
		return turnoId;
	}
	public void setTurnoId(Long turnoId) {
		this.turnoId = turnoId;
	}
	public Long getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(Long unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	public Long getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Long periodoId) {
		this.periodoId = periodoId;
	}
	public Long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
}
