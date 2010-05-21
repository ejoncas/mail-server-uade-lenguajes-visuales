package com.uade.beans.entities;

import java.io.Serializable;
import java.util.HashMap;

public class Inbox implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4798659227819111841L;
	private HashMap<Mail, Estado> estadoInbox;

	public Inbox(){
		this.estadoInbox = new HashMap<Mail, Estado>();
	}
	public HashMap<Mail, Estado> getEstadoInbox() {
		return estadoInbox;
	}

	public void setEstadoInbox(HashMap<Mail, Estado> estadoInbox) {
		this.estadoInbox = estadoInbox;
	}
	
	
	
}


