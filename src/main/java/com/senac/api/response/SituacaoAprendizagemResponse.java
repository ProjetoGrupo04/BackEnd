package com.senac.api.response;

import java.util.List;

import com.senac.api.entity.Badge;
import com.senac.api.entity.CopetenciaIndicador;
import com.senac.api.entity.GrauDificuldade;
import com.senac.api.entity.ObjetoAprendizagem;
import com.senac.api.entity.PlanejamentoUc;

public class SituacaoAprendizagemResponse{

	private Long id;
	private String titulo;
	private String descricao;
	private Boolean ordem;
	private Boolean status;
	private PlanejamentoUc planejamentoUcId;
	private GrauDificuldade grauDificuldadeId;
	private Badge badgeId;
	private List<CopetenciaIndicador> indicadores;
	private List<ObjetoAprendizagem> objetos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getOrdem() {
		return ordem;
	}
	public void setOrdem(Boolean ordem) {
		this.ordem = ordem;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public PlanejamentoUc getPlanejamentoUcId() {
		return planejamentoUcId;
	}
	public void setPlanejamentoUcId(PlanejamentoUc planejamentoUcId) {
		this.planejamentoUcId = planejamentoUcId;
	}
	public GrauDificuldade getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(GrauDificuldade grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Badge getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(Badge badgeId) {
		this.badgeId = badgeId;
	}
	public List<CopetenciaIndicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<CopetenciaIndicador> indicadores) {
		this.indicadores = indicadores;
	}
	public List<ObjetoAprendizagem> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<ObjetoAprendizagem> objetos) {
		this.objetos = objetos;
	}
	
}
