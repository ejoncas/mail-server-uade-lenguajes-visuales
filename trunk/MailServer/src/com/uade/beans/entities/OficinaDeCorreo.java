package com.uade.beans.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="oficinas")
public class OficinaDeCorreo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3428629613271626188L;
	private Long id;
	private String nombreOficina;
	private List<Casilla> casillasMiembro;
	private List<OficinaDeCorreo> oficinasDeConfianza;

	
	public String toString(){
		return this.nombreOficina;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
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
	@ManyToMany(fetch=FetchType.EAGER)
	public List<Casilla> getCasillasMiembro() {
		return casillasMiembro;
	}
	public void setCasillasMiembro(List<Casilla> casillasMiembro) {
		this.casillasMiembro = casillasMiembro;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	public List<OficinaDeCorreo> getOficinasDeConfianza() {
		return oficinasDeConfianza;
	}
	public void setOficinasDeConfianza(List<OficinaDeCorreo> oficinasDeConfianza) {
		this.oficinasDeConfianza = oficinasDeConfianza;
	}
	
	
	
	public OficinaDeCorreo() {
		this.oficinasDeConfianza = new ArrayList<OficinaDeCorreo>();
		this.casillasMiembro = new ArrayList<Casilla>();
	}
	
	public void addCasillaMiembro(Casilla c1) {
		this.casillasMiembro.add(c1);
	}
	
	public void addOficinaDeConfianza(OficinaDeCorreo o){
		this.oficinasDeConfianza.add(o);
	}
	
	public void removeCasillaMiembro(Casilla c){
		this.casillasMiembro.remove(c);
	}
	
	public void removeOficinaDeConfianza(OficinaDeCorreo o){
		this.oficinasDeConfianza.remove(o);
	}
	
}
