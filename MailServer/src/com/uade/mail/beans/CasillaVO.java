package com.uade.mail.beans;

import java.io.Serializable;


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
	
	public CasillaVO(){
	}


	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
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
	
	
}
