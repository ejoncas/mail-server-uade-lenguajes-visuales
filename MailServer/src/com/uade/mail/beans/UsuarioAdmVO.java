package com.uade.mail.beans;

import java.io.Serializable;

public class UsuarioAdmVO implements Serializable{

	private static final long serialVersionUID = 4191609387818312214L;
	private Long id;
	private String username;
	private String password;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "Username: "+this.username;
	}
	
		
	
}
