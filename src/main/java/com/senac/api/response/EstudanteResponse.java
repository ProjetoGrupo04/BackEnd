package com.senac.api.response;

import java.time.LocalDate;

import com.senac.api.entity.Oferta;
import com.senac.api.entity.Usuario;

public class EstudanteResponse{

	private Long id;
	private LocalDate dataCadastro = LocalDate.now();
	private LocalDate dataTrancamento;
	private LocalDate dataFormatura;
	private Boolean status;
	private Usuario usuarioId;
	private Oferta ofertaId;
	
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Oferta getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Oferta ofertaId) {
		this.ofertaId = ofertaId;
	}

}
