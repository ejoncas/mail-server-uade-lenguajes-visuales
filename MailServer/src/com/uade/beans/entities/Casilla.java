package com.uade.beans.entities;

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

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.EstadoMailVO;

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
	@ManyToOne
	public Usuario getInfoUsuario() {
		return infoUsuario;
	}
	public void setInfoUsuario(Usuario infoUsuario) {
		this.infoUsuario = infoUsuario;
	}
	
	@ManyToMany
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	public List<Casilla> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(List<Casilla> bloqueados) {
		this.bloqueados = bloqueados;
	}
	
	@OneToMany
	@JoinColumn(name="idcasilla")
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	public List<EstadoMail> getInbox() {
		return inbox;
	}
	public void setInbox(List<EstadoMail> inbox) {
		this.inbox = inbox;
	}
	
	public CasillaVO dameValueObject(){
		return new CasillaVO(this);
	}
	
	public Casilla(CasillaVO c){
		List<Casilla> casillas = new ArrayList<Casilla>();
		for(CasillaVO c1:c.getBloqueados())
			casillas.add(new Casilla(c1));
		this.bloqueados = casillas;
		List<EstadoMail> estados = new ArrayList<EstadoMail>();
		for(EstadoMailVO e : c.getInbox())
			estados.add(new EstadoMail(e));
		this.inbox = estados;
		this.infoUsuario = new Usuario(c.getInfoUsuario());
		this.nombre = c.getNombre();
		this.password = c.getPassword();
	}
	public Casilla() {
	}
	
	
	
}

