package com.uade.mail.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OficinaDeCorreoVO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7199150831295591617L;
	private Long id;
	private String nombreOficina;
	private List<CasillaVO> casillasMiembro;
	private List<OficinaDeCorreoVO> oficinasDeConfianza;

	
	
	

	public OficinaDeCorreoVO(String nombre){
		this.nombreOficina=nombre;
		this.casillasMiembro = new ArrayList<CasillaVO>();
		this.oficinasDeConfianza = new ArrayList<OficinaDeCorreoVO>();
	}
	
	public OficinaDeCorreoVO() {
		this.casillasMiembro = new ArrayList<CasillaVO>();
		this.oficinasDeConfianza = new ArrayList<OficinaDeCorreoVO>();
	}

	public Long getId() {
		return id;
	}
	public String getNombreOficina() {
		return nombreOficina;
	}
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	public List<CasillaVO> getCasillasMiembro() {
		return casillasMiembro;
	}
	public void setCasillasMiembro(List<CasillaVO> casillasMiembro) {
		this.casillasMiembro = casillasMiembro;
	}
	public List<OficinaDeCorreoVO> getOficinasDeConfianza() {
		return oficinasDeConfianza;
	}
	public void setOficinasDeConfianza(List<OficinaDeCorreoVO> oficinasDeConfianza) {
		this.oficinasDeConfianza = oficinasDeConfianza;
	}



	public void addOficinaDeCorreo(OficinaDeCorreoVO o2) {
		this.oficinasDeConfianza.add(o2);
	}

	public void addCasillaMiembro(CasillaVO c1) {
		this.casillasMiembro.add(c1);
	}
	
}
