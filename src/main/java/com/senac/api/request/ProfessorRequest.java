package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class ProfessorRequest{

	private Long id;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo usuario deve ser preenchido!!")
	private Long usuarioId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
