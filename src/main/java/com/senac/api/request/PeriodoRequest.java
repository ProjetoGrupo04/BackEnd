package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class PeriodoRequest{

	private Long id;
	@NotNull(message = "O campo nome deve ser preenchido!!")
	private String nome;
	@NotNull(message = "O campo status deve ser preenchido!!")
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
