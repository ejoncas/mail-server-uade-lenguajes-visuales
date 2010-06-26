package com.uade.web.ajax;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.uade.beans.entities.Casilla;
import com.uade.web.util.AccesoRMI;


public class AjaxHelper {
	
	public List<String> getContactsForUser(String username){
		List<String> r = new ArrayList<String>();
		try {
		
//				Casilla c = new Casilla();
//				c.setNombre(username);
				
				List<Casilla> contactos;
				
				contactos = AccesoRMI.getInstance().getServiceInterface().getAllAccounts();
				
				
				r.add("me<"+username+">");
				
				for(Casilla c1 : contactos)
					r.add(c1.getNombre());
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return r;
	}

}
