package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class CopetenciaRequest{
	
	private Long id;
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO ORDEM DEVE SER PREENCHIDO!!")
	private Integer ordem;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
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
