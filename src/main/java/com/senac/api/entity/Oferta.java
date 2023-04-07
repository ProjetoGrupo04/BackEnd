package com.senac.api.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oferta")
public class Oferta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oferta_id")
	private Long id;
	@Column(name = "oferta_descricao")
	private String descricao;
	@Column(name = "oferta_codigo")
	private String codigo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "oferta_inico_operacao")
	private LocalDate inicioOperacao = LocalDate.now();
	@Column(name = "oferta_status")
	private Boolean status;
	@ManyToOne//Colocar ManyToOne!!!
	@JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
	private Curso cursoId;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getInicioOperacao() {
		return inicioOperacao;
	}
	public void setInicioOperacao(LocalDate inicioOperacao) {
		this.inicioOperacao = inicioOperacao;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Curso getCursoId() {
		return cursoId;
	}
	public void setCursoId(Curso cursoId) {
		this.cursoId = cursoId;
	}
		
}
