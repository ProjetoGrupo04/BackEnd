package com.senac.api.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "situacao_aprendizagem")
public class SituacaoAprendizagem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "situacao_aprendizagem_id")
	private Long id;
	@Column(name = "situacao_aprendizagem_titulo")
	private String titulo;
	@Column(name = "situacao_aprendizagem_descricao")
	private String descricao;
	@Column(name = "situacao_aprendizagem_ordem")
	private Boolean ordem;
	@Column(name = "situacao_aprendizagem_status")
	private Boolean status;
	@ManyToOne
	@JoinColumn(name = "planejamento_uc_id", referencedColumnName = "planejamento_uc_id")
	private PlanejamentoUc planejamentoUcId;
	@OneToOne
	@JoinColumn(name = "grau_dificuldade_id", referencedColumnName = "grau_dificuldade_id")
	private GrauDificuldade grauDificuldadeId;
	@OneToOne
	@JoinColumn(name = "badge_id", referencedColumnName = "badge_id")
	private Badge badgeId;
	//@OneToMany(mappedBy="situacao_aprendizagem_id")
	//@JsonIgnore
	//private List<Atividade> atividades;
	@ManyToMany
	@JoinTable(
		name = "indicador_situacao_aprendizagens",
		joinColumns = { @JoinColumn(name = "situacao_aprendizagem_id", referencedColumnName = "situacao_aprendizagem_id")},
		inverseJoinColumns = { @JoinColumn(name = "copetencia_indicador_id", referencedColumnName = "copetencia_indicador_id")} 
	)
	@Column(name = "indicadores")
	private List<CopetenciaIndicador> indicadores;
	
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
	
	

}
