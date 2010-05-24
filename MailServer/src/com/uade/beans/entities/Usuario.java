package com.uade.beans.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uade.mail.beans.UsuarioVO;

@Entity
@Table(name="usuarios")
public class Usuario{

	
	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public UsuarioVO dameValueObject(){
		UsuarioVO r = new UsuarioVO(this);
		return r;
	}
	
	public Usuario(){}
	public Usuario(UsuarioVO u){
		this.nombre = u.getNombre();
		this.direccion = u.getDireccion();
		this.dni = u.getDni();
		this.nombre = u.getDni();
	}
	
}
