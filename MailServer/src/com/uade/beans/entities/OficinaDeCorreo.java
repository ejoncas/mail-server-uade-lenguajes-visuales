package com.uade.beans.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.OficinaDeCorreoVO;

@Entity
@Table(name="oficinas")
public class OficinaDeCorreo{
	
	
	private Long id;
	private String nombreOficina;
	private List<Casilla> casillasMiembro;
	private List<OficinaDeCorreo> oficinasDeConfianza;

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
	@ManyToMany
	public List<Casilla> getCasillasMiembro() {
		return casillasMiembro;
	}
	public void setCasillasMiembro(List<Casilla> casillasMiembro) {
		this.casillasMiembro = casillasMiembro;
	}
	
	@ManyToMany
	public List<OficinaDeCorreo> getOficinasDeConfianza() {
		return oficinasDeConfianza;
	}
	public void setOficinasDeConfianza(List<OficinaDeCorreo> oficinasDeConfianza) {
		this.oficinasDeConfianza = oficinasDeConfianza;
	}
	
	public OficinaDeCorreoVO dameValueObject(){
		return new OficinaDeCorreoVO(this);
	}
	
	public OficinaDeCorreo(OficinaDeCorreoVO o){
		List<Casilla> miembros = new ArrayList<Casilla>();
		for(CasillaVO c : o.getCasillasMiembro())
			miembros.add(new Casilla(c));
		this.casillasMiembro = miembros;
		this.nombreOficina = o.getNombreOficina();
		List<OficinaDeCorreo> of = new ArrayList<OficinaDeCorreo>();
		for(OficinaDeCorreoVO oo: o.getOficinasDeConfianza())
			of.add(new OficinaDeCorreo(oo));
		this.oficinasDeConfianza = of;
	}
	
	public OficinaDeCorreo() {
	}
	
}
