package com.uade.beans.entities;

import java.io.Serializable;
import java.util.HashSet;

public class Casilla implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8170596700073558218L;
	private String nombre;
	private String password;
	private Usuario infoUsuario;
	private HashSet<Casilla> bloqueados;
	private Inbox inbox;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Inbox getInbox() {
		return inbox;
	}
	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public HashSet<Casilla> getBloqueados() {
		return bloqueados;
	}

	public void setBloqueados(HashSet<Casilla> bloqueados) {
		this.bloqueados = bloqueados;
	}

	public Usuario getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(Usuario infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	
	
	
}
