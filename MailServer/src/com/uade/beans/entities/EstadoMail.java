package com.uade.beans.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name="estadomail")
public class EstadoMail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291240811330284636L;
	private Long id;
	private Mail mail;
	private String estado;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@Cascade(value=CascadeType.DELETE_ORPHAN)
	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public EstadoMail() {
	}
	
}


