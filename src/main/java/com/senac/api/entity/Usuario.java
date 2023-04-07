package com.senac.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	//@CPF
	@Column(name = "usuario_cpf", unique = true)
	private String cpf;
	@Column(name = "usuario_nome_completo")
	private String nomeCompleto;
	@Column(name = "user_apelido")
	private String apelido;
	@Column(name = "usuario_email", unique = true)
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "usuario_data_nascimento")
	private Date dataNascimento;
	@Column(name = "usuario_telefone")
	private String telefone;
	@Column(name = "atendimento_data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate atendimentoDataCadastro = LocalDate.now();
	@JsonIgnore
	@Lob
	@Column(name = "usuario_foto", columnDefinition="longblob")
	private byte[] foto;	
	//@JsonIgnore
	@Column(name = "usuario_senha")
	private String senha;
	@Column(name = "usuario_status")
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
