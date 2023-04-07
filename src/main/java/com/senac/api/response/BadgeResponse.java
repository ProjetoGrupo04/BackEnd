package com.senac.api.response;

public class BadgeResponse{

	private Long id;
	private String descricao;
	private byte[] img;
	private Integer status;
	private BadgeNivelResponse badgeNivelId;

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BadgeNivelResponse getBadgeNivelId() {
		return badgeNivelId;
	}

	public void setBadgeNivelId(BadgeNivelResponse badgeNivelId) {
		this.badgeNivelId = badgeNivelId;
	}


	
}
