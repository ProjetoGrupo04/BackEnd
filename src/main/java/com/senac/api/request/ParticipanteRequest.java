package com.senac.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class ParticipanteRequest{
	
	private Long id;
	@NotNull(message = "O campo data matricula deve ser preenchido!!")
	private LocalDate dataMatricula = LocalDate.now();
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo grupo deve ser preenchido!!")
	private Long grupoId;
	@NotNull(message = "O campo estudante deve ser preenchido!!")
	private Long estudanteId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}
	public Long getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Long estudanteId) {
		this.estudanteId = estudanteId;
	}
	
}
