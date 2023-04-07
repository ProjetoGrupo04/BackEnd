package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class IndicadorSituacaoAprendizagemRequest{
	
	private Long id;
	@NotNull(message = "O campo copetencia indicador deve ser preenchido!!")
	private Long copetenciaIndicadorId;
	@NotNull(message = "O campo situacao aprendizagem deve ser preenchido!!")
	private Long situacaoAprendizagemId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCopetenciaIndicadorId() {
		return copetenciaIndicadorId;
	}
	public void setCopetenciaIndicadorId(Long copetenciaIndicadorId) {
		this.copetenciaIndicadorId = copetenciaIndicadorId;
	}
	public Long getSituacaoAprendizagemId() {
		return situacaoAprendizagemId;
	}
	public void setSituacaoAprendizagemId(Long situacaoAprendizagemId) {
		this.situacaoAprendizagemId = situacaoAprendizagemId;
	}

}
