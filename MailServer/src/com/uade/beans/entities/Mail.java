package com.uade.beans.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.uade.mail.beans.MailVO;


@Entity
@Table(name="mails")
public class Mail implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3219938078669098296L;
	private Long id;
	private Casilla from;
	private List<Casilla> to;
	private String subject;
	private String message;
	private Date sentDate;
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@Cascade(value=CascadeType.SAVE_UPDATE)
	public Casilla getFrom() {
		return from;
	}
	public void setFrom(Casilla from) {
		this.from = from;
	}
	
	@ManyToMany
	@Cascade(value=CascadeType.SAVE_UPDATE)
	public List<Casilla> getTo() {
		return to;
	}
	public void setTo(List<Casilla> to) {
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

	
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public Mail() {
	}

	public MailVO valueObject(){
		MailVO m = new MailVO();
		m.setFrom(from.getNombre());
		m.setId(id);
		m.setMessage(message);
		m.setSentDate(sentDate);
		m.setSubject(subject);
		List<String> r = new ArrayList<String>();
		for(Casilla c : to)
			r.add(c.getNombre());
		m.setTo(r);
		return m;
	}
	

}

