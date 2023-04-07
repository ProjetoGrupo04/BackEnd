package com.senac.api.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class DiaLetivoRequest{
	private Long id;
	@NotNull(message = "O campo dia letivo deve ser preenchido!!")
	private Date diaLetivo;
	@NotNull(message = "O campo dia deve ser preenchido!!")
	private Integer diaLetivoDia;
	@NotNull(message = "O campo mês deve ser preenchido!!")
	private Integer diaLetivoMes;
	@NotNull(message = "O campo ano deve ser preenchido!!")
	private Integer diaLetivoAno;
	@NotNull(message = "O campo semana deve ser preenchido!!")
	private Integer diaLetivoSemana;
	@NotNull(message = "O campo status deve ser preenchido!!")
	private Integer diaLetivoStatus;
	@NotNull(message = "O campo periodo deve ser preenchido!!")
	private Long periodoId;
	
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
	public Long getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Long periodoId) {
		this.periodoId = periodoId;
	}
	
}
