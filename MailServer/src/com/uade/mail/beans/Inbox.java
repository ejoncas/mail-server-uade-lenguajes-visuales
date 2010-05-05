package com.uade.mail.beans;

import java.io.Serializable;
import java.util.HashMap;

public class Inbox implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8739695856410122183L;
	private HashMap<Mail, Estado> estadoInbox;

	public HashMap<Mail, Estado> getEstadoInbox() {
		return estadoInbox;
	}

	public void setEstadoInbox(HashMap<Mail, Estado> estadoInbox) {
		this.estadoInbox = estadoInbox;
	}
	
	
	
}


