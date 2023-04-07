package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class ModuloRequest{

	private Long id;	
	@NotNull(message = "O campo descrição deve ser preenchido!!")
	private String descricao;
	@NotNull(message = "O campo carga horária deve ser preenchido!!")
	private Integer cargaHoraria;
	@NotNull(message = "O campo oferta aprendizagem deve ser preenchido!!")
	private Long ofertaId;

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
	public Long getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Long ofertaId) {
		this.ofertaId = ofertaId;
	}
	

}
