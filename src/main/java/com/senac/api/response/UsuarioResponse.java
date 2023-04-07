package com.senac.api.response;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioResponse {
	
	private Long id;
	private String cpf;
	private String nomeCompleto;
	private String apelido;
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private String telefone;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate atendimentoDataCadastro = LocalDate.now();
	private byte[] foto;
	private Boolean status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getAtendimentoDataCadastro() {
		return atendimentoDataCadastro;
	}
	public void setAtendimentoDataCadastro(LocalDate atendimentoDataCadastro) {
		this.atendimentoDataCadastro = atendimentoDataCadastro;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
