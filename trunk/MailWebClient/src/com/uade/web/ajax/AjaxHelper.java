package com.uade.web.ajax;

import java.util.ArrayList;
import java.util.List;

import com.uade.beans.entities.Casilla;


public class AjaxHelper {
	
	public List<String> getContactsForUser(String username){
		
		List<String> r = new ArrayList<String>();
		
		//TODO - Call getContacts getting the Casilla first
		
		r.add("me<"+username+">");
		r.add("casilla1@"+Casilla.SERVER_DOMAIN);
		r.add("casilla2@"+Casilla.SERVER_DOMAIN);
		r.add("123casilla@"+Casilla.SERVER_DOMAIN);
		r.add("test@"+Casilla.SERVER_DOMAIN);
		r.add("autocomple@"+Casilla.SERVER_DOMAIN);
		r.add("anda10puntos@"+Casilla.SERVER_DOMAIN);
		r.add("test@"+Casilla.SERVER_DOMAIN);
		
		return r;
	}

}
