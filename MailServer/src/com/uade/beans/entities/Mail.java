package com.uade.beans.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.uade.mail.beans.MailVO;

@Entity
@Table(name="mails")
public class Mail{


	private Long id;
	private Casilla from;
	private Casilla to;
	private String subject;
	private String message;
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@OneToOne
	public Casilla getFrom() {
		return from;
	}
	public void setFrom(Casilla from) {
		this.from = from;
	}
	@OneToOne
	public Casilla getTo() {
		return to;
	}
	public void setTo(Casilla to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public MailVO dameValueObject(){
		return new MailVO(this);
	}
	
	public Mail(MailVO m){
		this.from = new Casilla(m.getFrom());
		this.to = new Casilla(m.getTo());
		this.message = m.getMessage();
		this.subject = m.getSubject();
	}
	public Mail() {
	}
	
	

}

