package com.senac.api.response;

import com.senac.api.entity.CopetenciaIndicador;
import com.senac.api.entity.SituacaoAprendizagem;

public class IndicadorSituacaoAprendizagemResponse{
	
	private Long id;
	private CopetenciaIndicador copetenciaIndicadorId;
	private SituacaoAprendizagem situacaoAprendizagemId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CopetenciaIndicador getCopetenciaIndicadorId() {
		return copetenciaIndicadorId;
	}
	public void setCopetenciaIndicadorId(CopetenciaIndicador copetenciaIndicadorId) {
		this.copetenciaIndicadorId = copetenciaIndicadorId;
	}
	public SituacaoAprendizagem getSituacaoAprendizagemId() {
		return situacaoAprendizagemId;
	}
	public void setSituacaoAprendizagemId(SituacaoAprendizagem situacaoAprendizagemId) {
		this.situacaoAprendizagemId = situacaoAprendizagemId;
	}
	
}
