package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class CursoTipoRequest{

	private Long id;	
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
