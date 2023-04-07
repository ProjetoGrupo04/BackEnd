package com.senac.api.request;

import java.util.List;

import com.senac.api.entity.SituacaoAprendizagem;

import jakarta.validation.constraints.NotNull;

public class ObjetoAprendizagemRequest{
	
	private Long id;
	@NotNull(message = "O campo descricao deve ser preenchido!!")
	private String descricao;
	@NotNull(message = "O campo blob deve ser preenchido!!")
	private byte[] blob;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo grau dificuldade deve ser preenchido!!")
	private Long grauDificuldadeId;
	@NotNull(message = "O campo usuario deve ser preenchido!!")
	private Long usuarioId;
	@NotNull(message = "O campo usuario deve ser preenchido!!")
	private List<SituacaoAprendizagem> aprendizagens;
	
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
	public byte[] getBlob() {
		return blob;
	}
	public void setBlob(byte[] blob) {
		this.blob = blob;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(Long grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<SituacaoAprendizagem> getAprendizagens() {
		return aprendizagens;
	}
	public void setAprendizagens(List<SituacaoAprendizagem> aprendizagens) {
		this.aprendizagens = aprendizagens;
	}
	
	
}
