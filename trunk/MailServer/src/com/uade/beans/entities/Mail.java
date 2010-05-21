package com.uade.beans.entities;

import java.io.Serializable;

public class Mail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8436467574116565414L;
	private Casilla from;
	private Casilla to;
	private String subject;
	private String message;
	
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
	
	public Casilla getFrom() {
		return from;
	}
	public void setFrom(Casilla from) {
		this.from = from;
	}
	public Casilla getTo() {
		return to;
	}
	public void setTo(Casilla to) {
		this.to = to;
	}
	
	

}

