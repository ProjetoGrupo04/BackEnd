package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class GrauDificuldadeRequest{

	private Long id;
	@NotNull(message = "O campo descricao deve ser preenchido!!")
	private String descricao;
	@NotNull(message = "O campo status deve ser preenchido!!")
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
