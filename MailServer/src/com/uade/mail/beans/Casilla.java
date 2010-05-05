package com.uade.mail.beans;

import java.io.Serializable;
import java.util.HashSet;

public class Casilla implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8170596700073558218L;
	public static String SERVER_DOMAIN = "lenguajes.edu.ar";
	public static int MAX_CHARACTERS = 20;
	private String nombre;
	private String password;
	private String nombreDuenio;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casilla other = (Casilla) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreDuenio() {
		return nombreDuenio;
	}
	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}
	public HashSet<Casilla> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(HashSet<Casilla> bloqueados) {
		this.bloqueados = bloqueados;
	}

	
	
}
