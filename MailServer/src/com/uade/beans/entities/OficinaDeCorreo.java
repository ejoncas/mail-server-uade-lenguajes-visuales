package com.uade.beans.entities;

import java.io.Serializable;
import java.util.HashSet;

public class OficinaDeCorreo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3734982664715988832L;
	private String nombreOficina;
	private HashSet<Casilla> casillasMiembro;
	private HashSet<OficinaDeCorreo> oficinasDeConfianza;

	
	


	public void addCasillaMiembro(Casilla c){
		this.casillasMiembro.add(c);
	}
	
	public void addOficinaDeCorreo(OficinaDeCorreo o){
		this.oficinasDeConfianza.add(o);
	}
	
	public OficinaDeCorreo(){
		casillasMiembro=new HashSet<Casilla>();
		oficinasDeConfianza=new HashSet<OficinaDeCorreo>();
	}
	
	public OficinaDeCorreo(String nombre){
		nombreOficina = nombre;
		casillasMiembro=new HashSet<Casilla>();
		oficinasDeConfianza=new HashSet<OficinaDeCorreo>();
	}
	public String getNombreOficina() {
		return nombreOficina;
	}
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	public HashSet<Casilla> getCasillasMiembro() {
		return casillasMiembro;
	}
	public void setCasillasMiembro(HashSet<Casilla> casillasMiembro) {
		this.casillasMiembro = casillasMiembro;
	}
	public HashSet<OficinaDeCorreo> getOficinasDeConfianza() {
		return oficinasDeConfianza;
	}
	public void setOficinasDeConfianza(HashSet<OficinaDeCorreo> oficinasDeConfianza) {
		this.oficinasDeConfianza = oficinasDeConfianza;
	}
	
	
	
	
}
