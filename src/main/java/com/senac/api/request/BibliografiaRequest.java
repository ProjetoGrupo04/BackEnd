package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class BibliografiaRequest{

	private Long id;
	@NotNull(message = "O CAMPO NOME DEVE SER PREENCHIDO!!")
	private String nome;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	@NotNull(message = "O CAMPO UNIDADE CURRICULAR DEVE SER PREENCHIDO!!")
	private Long unidadeCurricularId;

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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(Long unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}

}
