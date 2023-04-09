package com.senac.api.response;

import java.util.List;

import com.senac.api.entity.GrauDificuldade;
import com.senac.api.entity.SituacaoAprendizagem;
import com.senac.api.entity.Usuario;

public class ObjetoAprendizagemResponse{
	
	private Long id;
	private String descricao;
	private byte[] blob;
	private Boolean status;
	private GrauDificuldade grauDificuldadeId;
	private Usuario usuarioId;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public GrauDificuldade getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(GrauDificuldade grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<SituacaoAprendizagem> getAprendizagens() {
		return aprendizagens;
	}
	public void setAprendizagens(List<SituacaoAprendizagem> aprendizagens) {
		this.aprendizagens = aprendizagens;
	}
	
	
}
