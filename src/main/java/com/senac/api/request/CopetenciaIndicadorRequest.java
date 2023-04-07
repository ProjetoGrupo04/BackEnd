package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class CopetenciaIndicadorRequest{

	private Long id;
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	@NotNull(message = "O CAMPO COPETENCIA DEVE SER PREENCHIDO!!")
	private Long copetenciaId;
	
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
	public Long getCopetenciaId() {
		return copetenciaId;
	}
	public void setCopetenciaId(Long copetenciaId) {
		this.copetenciaId = copetenciaId;
	}
	

}
