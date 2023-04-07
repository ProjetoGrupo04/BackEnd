package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class CursoRequest{

	private Long id;
	@NotNull(message = "O CAMPO NOME DEVE SER PREENCHIDO!!")
	private String nome;
	@NotNull(message = "O CAMPO CODIGO DEVE SER PREENCHIDO!!")
	private String codigo;
	@NotNull(message = "O CAMPO CURSO TIPO DEVE SER PREENCHIDO!!")
	private Long cursoTipoId;
	private Integer horas;
	private Integer status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getCursoTipoId() {
		return cursoTipoId;
	}
	public void setCursoTipoId(Long cursoTipoId) {
		this.cursoTipoId = cursoTipoId;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
