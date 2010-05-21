package com.uade.beans.entities;

import java.io.Serializable;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2470877119556848768L;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	


	
	
}
