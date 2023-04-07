package com.senac.api.response;

import java.util.Date;

import com.senac.api.entity.EncontroTipo;

public class EncontroResponse{
	
	private Long id;
	private String observacao;
	private Long diaLetivoId;
	private Long grupoId;
	private Date dataInicio;
	private Date dataFim;
	private String local;
	private Boolean status;
	private EncontroTipo encontroTipoId;
	
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public EncontroTipo getEncontroTipoId() {
		return encontroTipoId;
	}
	public void setEncontroTipoId(EncontroTipo encontroTipoId) {
		this.encontroTipoId = encontroTipoId;
	}
	
}
