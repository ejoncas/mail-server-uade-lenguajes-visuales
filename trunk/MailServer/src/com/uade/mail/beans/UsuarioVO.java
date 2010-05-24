package com.uade.mail.beans;

import java.io.Serializable;

public class UsuarioVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -439904650779696727L;
	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	
	public String toString(){
		return this.nombre+" "+this.apellido;
	}
	
	public UsuarioVO(String nombre, String apellido, String direccion, String dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.dni=dni;
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
