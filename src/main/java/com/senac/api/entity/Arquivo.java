package com.senac.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "arquivo")
public class Arquivo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arquivo_id")
	private Integer id;
	
	@Column(name = "arquivo_descricao")
	private String Descricao;
	
	@Column(name = "arquivo_nome_arquivo")
	private String nomeArquivo;
	
	@Column(name = "arquivo_atividade_extensao")
	private String extensao;
	
	@Column(name = "arquivo_size")
	private Long fileSize;
	
	@Column(name = "arquivo_data_cadastro")
	private Date dataCadastro = new Date();
	
	@Lob
	@Column(name = "arquivo_blob", columnDefinition="longblob")
	private byte[] blob;
	
	@Column(name = "arquivo_status")
	private Boolean status;
	
	@ManyToMany
	@JoinTable(
		name = "arquivo_atividade",
		joinColumns = { @JoinColumn(name = "arquivo_id", referencedColumnName = "arquivo_id")},
		inverseJoinColumns = { @JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")} 
	)
	@Column(name = "atividades")
	private List<Atividade> atividades;

	public Arquivo() {
		super();
	}

	public Arquivo(Integer id, String descricao, String nomeArquivo, String extensao, Long fileSize, Date dataCadastro,
			byte[] blob, Boolean status) {
		super();
		this.id = id;
		Descricao = descricao;
		this.nomeArquivo = nomeArquivo;
		this.extensao = extensao;
		this.fileSize = fileSize;
		this.dataCadastro = dataCadastro;
		this.blob = blob;
		this.status = status;
	}

	public Arquivo(String descricao, String nomeArquivo, String extensao, Long fileSize, Date dataCadastro, byte[] blob,
			Boolean status) {
		super();
		Descricao = descricao;
		this.nomeArquivo = nomeArquivo;
		this.extensao = extensao;
		this.fileSize = fileSize;
		this.dataCadastro = dataCadastro;
		this.blob = blob;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	
}
