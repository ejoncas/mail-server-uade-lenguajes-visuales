package com.uade.mail.beans;

import java.util.HashSet;

public class OficinaDeCorreoVO{
	
	private String nombreOficina;
	private HashSet<CasillaVO> casillasMiembro;
	private HashSet<OficinaDeCorreoVO> oficinasDeConfianza;

	
	


	public void addCasillaMiembro(CasillaVO c){
		this.casillasMiembro.add(c);
	}
	
	public void addOficinaDeCorreo(OficinaDeCorreoVO o){
		this.oficinasDeConfianza.add(o);
	}
	
	public OficinaDeCorreoVO(){
		casillasMiembro=new HashSet<CasillaVO>();
		oficinasDeConfianza=new HashSet<OficinaDeCorreoVO>();
	}
	
	public OficinaDeCorreoVO(String nombre){
		nombreOficina = nombre;
		casillasMiembro=new HashSet<CasillaVO>();
		oficinasDeConfianza=new HashSet<OficinaDeCorreoVO>();
	}
	
	
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
		OficinaDeCorreoVO other = (OficinaDeCorreoVO) obj;
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
	public HashSet<CasillaVO> getCasillasMiembro() {
		return casillasMiembro;
	}
	public void setCasillasMiembro(HashSet<CasillaVO> casillasMiembro) {
		this.casillasMiembro = casillasMiembro;
	}
	public HashSet<OficinaDeCorreoVO> getOficinasDeConfianza() {
		return oficinasDeConfianza;
	}
	public void setOficinasDeConfianza(HashSet<OficinaDeCorreoVO> oficinasDeConfianza) {
		this.oficinasDeConfianza = oficinasDeConfianza;
	}
	
	
	
	
}
