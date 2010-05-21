package com.uade.mail.beans;

import java.util.HashMap;

public class InboxVO{
	
	
	private HashMap<MailVO, EstadoVO> estadoInbox;

	public InboxVO(){
		this.estadoInbox = new HashMap<MailVO, EstadoVO>();
	}
	public HashMap<MailVO, EstadoVO> getEstadoInbox() {
		return estadoInbox;
	}

	public void setEstadoInbox(HashMap<MailVO, EstadoVO> estadoInbox) {
		this.estadoInbox = estadoInbox;
	}
	
	
	
}


