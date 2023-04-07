package com.senac.api.request;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {
	
	private Long id;
	@NotNull(message = "O CAMPO CPF DEVE SER PREENCHIDO!!")
	private String cpf;
	@NotNull(message = "O CAMPO NOME COMPLETO DEVE SER PREENCHIDO!!")
	private String nomeCompleto;
	@NotNull(message = "O CAMPO APELIDO DEVE SER PREENCHIDO!!")
	private String apelido;
	@NotNull(message = "O CAMPO EMAIL DEVE SER PREENCHIDO!!")
	private String email;
	@NotNull(message = "O CAMPO DATA NASCIMENTO DEVE SER PREENCHIDO!!")
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	@NotNull(message = "O CAMPO TELEFONE DEVE SER PREENCHIDO!!")
	private String telefone;
	@NotNull(message = "O CAMPO DATA CADASTRO DEVE SER PREENCHIDO!!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate atendimentoDataCadastro = LocalDate.now();
	private byte[] foto;
	@NotNull(message = "O CAMPO SENHA DEVE SER PREENCHIDO!!")
	private String senha;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
