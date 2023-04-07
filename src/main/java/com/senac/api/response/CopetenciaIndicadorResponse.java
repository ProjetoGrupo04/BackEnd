package com.senac.api.response;

import java.util.List;

import com.senac.api.entity.Copetencia;
import com.senac.api.entity.SituacaoAprendizagem;

public class CopetenciaIndicadorResponse{

	private Long id;
	private String descricao;
	private Boolean status;
	private Copetencia copetenciaId;
	private List<SituacaoAprendizagem> situacoesAprendizagens;
	
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Copetencia getCopetenciaId() {
		return copetenciaId;
	}
	public void setCopetenciaId(Copetencia copetenciaId) {
		this.copetenciaId = copetenciaId;
	}
	public List<SituacaoAprendizagem> getSituacoesAprendizagens() {
		return situacoesAprendizagens;
	}
	public void setSituacoesAprendizagens(List<SituacaoAprendizagem> situacoesAprendizagens) {
		this.situacoesAprendizagens = situacoesAprendizagens;
	}
	

}
