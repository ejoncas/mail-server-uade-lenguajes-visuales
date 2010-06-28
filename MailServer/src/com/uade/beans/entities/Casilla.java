package com.uade.beans.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="casillas")
public class Casilla implements Serializable{

	
	private static final long serialVersionUID = 8144608022288769195L;
	public static final String SERVER_DOMAIN = "lenguajes.edu.ar";
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
	
	@ManyToOne
	public Usuario getInfoUsuario() {
		return infoUsuario;
	}
	public void setInfoUsuario(Usuario infoUsuario) {
		this.infoUsuario = infoUsuario;
	}
	
	@ManyToMany
	@Cascade(value=CascadeType.SAVE_UPDATE)
	public List<Casilla> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(List<Casilla> bloqueados) {
		this.bloqueados = bloqueados;
	}
	
	@OneToMany
	@JoinColumn(name="idcasilla")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	public List<EstadoMail> getInbox() {
		return inbox;
	}
	public void setInbox(List<EstadoMail> inbox) {
		this.inbox = inbox;
	}
	
	public String toString(){
		return this.nombre;
	}
	
	public Casilla() {
		bloqueados=new ArrayList<Casilla>();
		inbox = new ArrayList<EstadoMail>();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

