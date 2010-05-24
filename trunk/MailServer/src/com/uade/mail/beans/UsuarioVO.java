package com.uade.mail.beans;

import java.io.Serializable;

public class UsuarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3232777049451961521L;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	
	public String toString(){
		return this.nombre+" "+this.apellido;
	}
	public UsuarioVO(String nombre2, String apellido2, String direccion2,
			String dni2) {
		this.nombre=nombre2;
		this.apellido = apellido2;
		this.direccion = direccion2;
		this.dni = dni2;
	}
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
