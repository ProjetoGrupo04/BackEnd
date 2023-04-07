package com.senac.api.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "modulo_id")
	private Long id;	
	@Column(name = "modulo_descricao")
	private String descricao;
	@Column(name = "modulo_carga_horaria")
	private Integer cargaHoraria;
	@OneToOne
	@JoinColumn(name = "oferta_id", referencedColumnName = "oferta_id")
	private Oferta ofertaId;
	@JsonIgnore
	@OneToMany(mappedBy = "moduloId")
	private List<UnidadeCurricular> unidadeCurriculares;

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
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Oferta getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Oferta ofertaId) {
		this.ofertaId = ofertaId;
	}
	public List<UnidadeCurricular> getUnidadeCurriculares() {
		return unidadeCurriculares;
	}
	public void setUnidadeCurriculares(List<UnidadeCurricular> unidadeCurriculares) {
		this.unidadeCurriculares = unidadeCurriculares;
	}

}
