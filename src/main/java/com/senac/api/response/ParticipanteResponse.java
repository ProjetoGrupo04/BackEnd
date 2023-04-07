package com.senac.api.response;

import java.time.LocalDate;

import com.senac.api.entity.Estudante;
import com.senac.api.entity.Grupo;

public class ParticipanteResponse{
	
	private Long id;
	private LocalDate dataMatricula = LocalDate.now();
	private Boolean status;
	private Grupo grupoId;
	private Estudante estudanteId;
	
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
		this.grupoId = grupoId;
	}
	public Estudante getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Estudante estudanteId) {
		this.estudanteId = estudanteId;
	}
	
}
