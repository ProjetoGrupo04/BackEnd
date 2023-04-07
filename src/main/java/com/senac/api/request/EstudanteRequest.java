package com.senac.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class EstudanteRequest{

	private Long id;
	private LocalDate dataCadastro = LocalDate.now();
	@NotNull(message = "O campo data trancamento deve ser preenchido!!")
	private LocalDate dataTrancamento;
	@NotNull(message = "O campo data formatura deve ser preenchido!!")
	private LocalDate dataFormatura;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo usuario deve ser preenchido!!")
	private Long usuarioId;
	@NotNull(message = "O campo oferta deve ser preenchido!!")
	private Long ofertaId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDate getDataTrancamento() {
		return dataTrancamento;
	}
	public void setDataTrancamento(LocalDate dataTrancamento) {
		this.dataTrancamento = dataTrancamento;
	}
	public LocalDate getDataFormatura() {
		return dataFormatura;
	}
	public void setDataFormatura(LocalDate dataFormatura) {
		this.dataFormatura = dataFormatura;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Long getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Long ofertaId) {
		this.ofertaId = ofertaId;
	}

}
