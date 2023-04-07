package com.senac.api.request;

import jakarta.validation.constraints.NotNull;

public class UnidadeCurricularRequest{
	
	private Long id;
	@NotNull(message = "O campo codigo deve ser preenchido!!")
	private String codigo;
	@NotNull(message = "O campo nome deve ser preenchido!!")
	private String nome;
	@NotNull(message = "O campo nome curto deve ser preenchido!!")
	private String nomeCurto;
	@NotNull(message = "O campo horas deve ser preenchido!!")
	private Integer horas;
	@NotNull(message = "O campo modulo deve ser preenchido!!")
	private Integer modulo;
	@NotNull(message = "O campo ordem deve ser preenchido!!")
	private Integer ordem;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer status;
	@NotNull(message = "O campo modulo deve ser preenchido!!")
	private Long moduloId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCurto() {
		return nomeCurto;
	}
	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Integer getModulo() {
		return modulo;
	}
	public void setModulo(Integer modulo) {
		this.modulo = modulo;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getModuloId() {
		return moduloId;
	}
	public void setModuloId(Long moduloId) {
		this.moduloId = moduloId;
	}

}
