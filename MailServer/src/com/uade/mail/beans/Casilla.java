package com.uade.mail.beans;

import java.util.ArrayList;
import java.util.HashSet;

public class Casilla {
	
	private String nombre;
	private String nombreDuenio;
	private HashSet<Casilla> bloqueados;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreDuenio() {
		return nombreDuenio;
	}
	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}
	public HashSet<Casilla> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(HashSet<Casilla> bloqueados) {
		this.bloqueados = bloqueados;
	}

	
	
}
