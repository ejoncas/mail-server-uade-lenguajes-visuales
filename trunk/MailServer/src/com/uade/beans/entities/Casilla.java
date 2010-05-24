package com.uade.beans.entities;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="casillas")
public class Casilla{

	
	private Long id;
	private String nombre;
	private String password;
	private Usuario infoUsuario;
	private List<Casilla> bloqueados;
	private List<EstadoMail> inbox;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToOne
	public Usuario getInfoUsuario() {
		return infoUsuario;
	}
	public void setInfoUsuario(Usuario infoUsuario) {
		this.infoUsuario = infoUsuario;
	}
	@OneToMany
	public List<Casilla> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(List<Casilla> bloqueados) {
		this.bloqueados = bloqueados;
	}
	@OneToMany
	public List<EstadoMail> getInbox() {
		return inbox;
	}
	public void setInbox(List<EstadoMail> inbox) {
		this.inbox = inbox;
	}
	
	
	
	
}
