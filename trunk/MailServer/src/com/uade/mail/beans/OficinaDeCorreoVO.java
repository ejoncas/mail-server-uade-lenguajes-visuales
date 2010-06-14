package com.uade.mail.beans;

import java.io.Serializable;

public class OficinaDeCorreoVO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7199150831295591617L;
	private Long id;
	private String nombreOficina;
	

	public OficinaDeCorreoVO(String nombre){
		this.nombreOficina=nombre;
	}
	
	public OficinaDeCorreoVO() {
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreOficina() {
		return nombreOficina;
	}
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	
}
