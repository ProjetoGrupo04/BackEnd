package com.senac.api.response;

import java.time.LocalDate;

import com.senac.api.entity.Curso;

public class OfertaResponse{
	
	private Long id;
	private String descricao;
	private String codigo;
	private LocalDate inicioOperacao = LocalDate.now();
	private Boolean status;
	private Curso cursoId;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getInicioOperacao() {
		return inicioOperacao;
	}
	public void setInicioOperacao(LocalDate inicioOperacao) {
		this.inicioOperacao = inicioOperacao;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Curso getCursoId() {
		return cursoId;
	}
	public void setCursoId(Curso cursoId) {
		this.cursoId = cursoId;
	}
		
}
