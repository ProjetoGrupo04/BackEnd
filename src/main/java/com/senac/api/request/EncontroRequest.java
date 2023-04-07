package com.senac.api.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class EncontroRequest{
	
	private Long id;
	@NotNull(message = "O campo observação deve ser preenchido!!")
	private String observacao;
	@NotNull(message = "O campo dia letivo deve ser preenchido!!")
	private Long diaLetivoId;
	@NotNull(message = "O campo grupo deve ser preenchido!!")
	private Long grupoId;
	@NotNull(message = "O campo data inicio deve ser preenchido!!")
	private Date dataInicio;
	@NotNull(message = "O campo data fim deve ser preenchido!!")
	private Date dataFim;
	@NotNull(message = "O campo local deve ser preenchido!!")
	private String local;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo encontro tipo deve ser preenchido!!")
	private Long encontroTipoId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Long getDiaLetivoId() {
		return diaLetivoId;
	}
	public void setDiaLetivoId(Long diaLetivoId) {
		this.diaLetivoId = diaLetivoId;
	}
	public Long getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getEncontroTipoId() {
		return encontroTipoId;
	}
	public void setEncontroTipoId(Long encontroTipoId) {
		this.encontroTipoId = encontroTipoId;
	}
	
}
