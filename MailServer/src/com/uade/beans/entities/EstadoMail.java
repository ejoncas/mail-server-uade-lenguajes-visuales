package com.uade.beans.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.uade.mail.beans.EstadoMailVO;


@Entity
@Table(name="estadomail")
public class EstadoMail{

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
	@Cascade(CascadeType.ALL)
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
	
	
	public EstadoMailVO dameValueObject(){
		return new EstadoMailVO(this);
	}
	
	public EstadoMail(EstadoMailVO e){
		this.estado = e.getEstado();
		this.mail = new Mail(e.getMail());
	}

	public EstadoMail() {
	}
	
}


