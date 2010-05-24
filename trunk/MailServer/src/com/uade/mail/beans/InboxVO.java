package com.uade.mail.beans;

import java.io.Serializable;
import java.util.HashMap;

public class InboxVO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6460668743557747950L;
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


