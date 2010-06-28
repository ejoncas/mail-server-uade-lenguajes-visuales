package com.uade.web.ajax;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	public void removeMail(HttpServletRequest request, long idAEliminar, String user){
		try {
			MailService service =AccesoRMI.getInstance().getServiceInterface();
			
			Thread.sleep(1000L);
			
			List<MailVO> leidos = (List<MailVO>) request.getSession().getAttribute("leidos");
			List<MailVO> noLeidos = (List<MailVO>) request.getSession().getAttribute("noLeidos");
			
			MailVO verMail = null;
			
			for(int i = 0 ; i<leidos.size() && verMail==null; i++){
				if(leidos.get(i).getId().equals(idAEliminar)){
					leidos.remove(i);//quiere borrar un leido
				}
			}
			
			for(int i = 0 ; i<noLeidos.size() && verMail==null; i++){
				if(noLeidos.get(i).getId().equals(idAEliminar)){
					noLeidos.remove(i);
				}
			}			
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
