package com.senac.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class OfertaRequest{
	
	private Long id;
	@NotNull(message = "O campo descricao deve ser preenchido!!")
	private String descricao;
	@NotNull(message = "O campo codigo deve ser preenchido!!")
	private String codigo;
	@NotNull(message = "O campo inicio operacao deve ser preenchido!!")
	private LocalDate inicioOperacao = LocalDate.now();
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo curso deve ser preenchido!!")
	private Long cursoId;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getCursoId() {
		return cursoId;
	}
	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
		
}
