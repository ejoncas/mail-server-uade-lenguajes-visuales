package com.uade.mail.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CasillaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7253711726501753324L;
	public static final String SERVER_DOMAIN = "lenguajes.edu.ar";
	private Long id;
	private String nombre;
	private String password;
	private UsuarioVO infoUsuario;
	private List<CasillaVO> bloqueados;
	private List<EstadoMailVO> inbox;
	
	public CasillaVO(){
		this.bloqueados = new ArrayList<CasillaVO>();
		this.inbox = new ArrayList<EstadoMailVO>();
	}
	
	

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsuarioVO getInfoUsuario() {
		return infoUsuario;
	}
	public void setInfoUsuario(UsuarioVO infoUsuario) {
		this.infoUsuario = infoUsuario;
	}
	
	public List<CasillaVO> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(List<CasillaVO> bloqueados) {
		this.bloqueados = bloqueados;
	}
	
	public List<EstadoMailVO> getInbox() {
		return inbox;
	}
	public void setInbox(List<EstadoMailVO> inbox) {
		this.inbox = inbox;
	}
	
}
