package com.uade.web.ajax;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.EstadosPosibles;
import com.uade.mail.beans.MailVO;
import com.uade.mail.interfaces.MailService;
import com.uade.web.util.AccesoRMI;


public class AjaxHelper {
	
	public void blockUser(String username, String blocked){
		
		try {
			MailService service =AccesoRMI.getInstance().getServiceInterface();
			
			Thread.sleep(1000L);
			
			service.addBloquedUser(username, blocked);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void removeMail(long idAEliminar, String user){
		try {
			MailService service =AccesoRMI.getInstance().getServiceInterface();
			
			Thread.sleep(1000L);
			
			MailVO m = new MailVO();
			
			m.setId(idAEliminar);
			
			service.changeEstadoMail(m, user, EstadosPosibles.TRASH);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getContactsForUser(String username){
		List<String> r = new ArrayList<String>();
		try {
		
				Casilla c = new Casilla();
				c.setNombre(username);
				
				List<Casilla> contactos;
				
				contactos = AccesoRMI.getInstance().getServiceInterface().getContacts(c);
				
				for(Casilla c1 : contactos)
					r.add(c1.getNombre());
		
				
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return r;
	}

}
