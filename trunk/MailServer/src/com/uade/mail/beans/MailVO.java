package com.uade.mail.beans;

import java.io.Serializable;

public class MailVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8294751832410362262L;
	private Long id;
	private CasillaVO from;
	private CasillaVO to;
	private String subject;
	private String message;
	
	
	
	
	public Long getId() {
		return id;
	}
	public CasillaVO getFrom() {
		return from;
	}
	public void setFrom(CasillaVO from) {
		this.from = from;
	}
	public CasillaVO getTo() {
		return to;
	}
	public void setTo(CasillaVO to) {
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
}

