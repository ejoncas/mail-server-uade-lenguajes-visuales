package com.uade.mail.beans;

import java.io.Serializable;


public class EstadoMailVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4620284268038198077L;
	private Long id;
	private MailVO mail;
	private String estado;
	
	

	
	public Long getId() {
		return id;
	}

	public MailVO getMail() {
		return mail;
	}

	public void setMail(MailVO mail) {
		this.mail = mail;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}


