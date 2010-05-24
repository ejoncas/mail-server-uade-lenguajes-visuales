package com.uade.beans.entities;

import java.util.Map;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="inboxes")
public class Inbox{

	private Long id;
	private Map<Mail, String> estadoInbox;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany
	public Map<Mail, String> getEstadoInbox() {
		return estadoInbox;
	}

	public void setEstadoInbox(Map<Mail, String> estadoInbox) {
		this.estadoInbox = estadoInbox;
	}
	
	
	
}


