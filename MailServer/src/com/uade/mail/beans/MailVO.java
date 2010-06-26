package com.uade.mail.beans;

import java.io.Serializable;
import java.util.Date;


public class MailVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8294751832410362262L;
	private Long id;
	private String from;
	private String to;
	private String subject;
	private String message;
	private Date sentDate;
	
	
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public MailVO() {
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	
}

