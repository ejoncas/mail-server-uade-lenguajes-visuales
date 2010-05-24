package com.uade.mail.beans;

import java.io.Serializable;
import java.util.HashSet;

public class CasillaVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4936005102902381936L;
	public static String SERVER_DOMAIN = "lenguajes.edu.ar";
	public static int MAX_CHARACTERS = 20;
	private String nombre;
	private String password;
	private UsuarioVO infoUsuario;
	private HashSet<CasillaVO> bloqueados;
	private InboxVO inbox;
	
	
	public CasillaVO(){
		this.nombre="";
		this.password="";
		this.bloqueados = new HashSet<CasillaVO>();
		this.inbox = new InboxVO();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public InboxVO getInbox() {
		return inbox;
	}
	public void setInbox(InboxVO inbox) {
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
		CasillaVO other = (CasillaVO) obj;
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
	
	public HashSet<CasillaVO> getBloqueados() {
		return bloqueados;
	}

	public void setBloqueados(HashSet<CasillaVO> bloqueados) {
		this.bloqueados = bloqueados;
	}

	public UsuarioVO getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(UsuarioVO infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	
	
	
}
