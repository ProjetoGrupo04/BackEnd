package com.senac.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class PlanejamentoUcRequest{

	private Long id;
	@NotNull(message = "O campo descricão deve ser preenchido!!")
	private String descricao;
	@NotNull(message = "O campo data aprovação deve ser preenchido!!")
	private LocalDate dataAprovacao = LocalDate.now();
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status; 
	@NotNull(message = "O campo grupo deve ser preenchido!!")
	private Long grupoId;
	
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
	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}
	public void setDataAprovacao(LocalDate dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}
	
}
