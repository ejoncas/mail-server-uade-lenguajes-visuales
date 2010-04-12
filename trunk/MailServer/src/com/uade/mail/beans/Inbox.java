package com.uade.mail.beans;

import java.util.HashMap;

public class Inbox {
	
	
	private HashMap<Mail, Estado> estadoInbox;

	public HashMap<Mail, Estado> getEstadoInbox() {
		return estadoInbox;
	}

	public void setEstadoInbox(HashMap<Mail, Estado> estadoInbox) {
		this.estadoInbox = estadoInbox;
	}
	
	
	
}


