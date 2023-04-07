package com.senac.api.response;

public class CursoResponse{

	private Long id;
	private String nome;
	private String codigo;
	private CursoTipoResponse cursoTipoId;
	private Integer horas;
	private Boolean status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public CursoTipoResponse getCursoTipoId() {
		return cursoTipoId;
	}
	public void setCursoTipoId(CursoTipoResponse cursoTipoId) {
		this.cursoTipoId = cursoTipoId;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
