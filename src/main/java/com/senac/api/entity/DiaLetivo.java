package com.senac.api.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "dia_letivo")
public class DiaLetivo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dia_letivo_id")
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dia_letivo")
	private Date diaLetivo;
	@Column(name = "dia_letivo_dia")
	private Integer diaLetivoDia;
	@Column(name = "dia_letivo_mes")
	private Integer diaLetivoMes;
	@Column(name = "dia_letivo_ano")
	private Integer diaLetivoAno;
	@Column(name = "dia_letivo_semana")
	private Integer diaLetivoSemana;
	@Column(name = "dia_letivo_status")
	private Integer diaLetivoStatus;
	@ManyToOne
	@JoinColumn(name = "periodo_id", referencedColumnName = "periodo_id")
	private Periodo periodoId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDiaLetivo() {
		return diaLetivo;
	}
	public void setDiaLetivo(Date diaLetivo) {
		this.diaLetivo = diaLetivo;
	}
	public Integer getDiaLetivoDia() {
		return diaLetivoDia;
	}
	public void setDiaLetivoDia(Integer diaLetivoDia) {
		this.diaLetivoDia = diaLetivoDia;
	}
	public Integer getDiaLetivoMes() {
		return diaLetivoMes;
	}
	public void setDiaLetivoMes(Integer diaLetivoMes) {
		this.diaLetivoMes = diaLetivoMes;
	}
	public Integer getDiaLetivoAno() {
		return diaLetivoAno;
	}
	public void setDiaLetivoAno(Integer diaLetivoAno) {
		this.diaLetivoAno = diaLetivoAno;
	}
	public Integer getDiaLetivoSemana() {
		return diaLetivoSemana;
	}
	public void setDiaLetivoSemana(Integer diaLetivoSemana) {
		this.diaLetivoSemana = diaLetivoSemana;
	}
	public Integer getDiaLetivoStatus() {
		return diaLetivoStatus;
	}
	public void setDiaLetivoStatus(Integer diaLetivoStatus) {
		this.diaLetivoStatus = diaLetivoStatus;
	}
	public Periodo getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Periodo periodoId) {
		this.periodoId = periodoId;
	}
	
}
