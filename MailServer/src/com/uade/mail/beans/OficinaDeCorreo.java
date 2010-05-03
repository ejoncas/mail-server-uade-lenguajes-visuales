package com.uade.mail.beans;

import java.util.HashSet;

public class OficinaDeCorreo {
	
	private String nombreOficina;
	private HashSet<Casilla> casillasMiembro;
	private HashSet<OficinaDeCorreo> oficinasDeConfianza;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombreOficina == null) ? 0 : nombreOficina.hashCode());
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
		OficinaDeCorreo other = (OficinaDeCorreo) obj;
		if (nombreOficina == null) {
			if (other.nombreOficina != null)
				return false;
		} else if (!nombreOficina.equals(other.nombreOficina))
			return false;
		return true;
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