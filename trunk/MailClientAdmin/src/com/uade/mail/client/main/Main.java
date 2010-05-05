package com.uade.mail.client.main;

import java.rmi.RemoteException;
import java.util.Vector;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.interfaces.MailService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			MailService service = MailClient.getInstance().getServiceInterface();
			
			
			
			Casilla c1 = new Casilla();
			Casilla c2 = new Casilla();
			Casilla c3 = new Casilla();
			c1.setNombre("cuenta1@"+Casilla.SERVER_DOMAIN);
			c2.setNombre("cuenta2@"+Casilla.SERVER_DOMAIN);
			c3.setNombre("cuenta3@"+Casilla.SERVER_DOMAIN);
			c1.setNombreDuenio("Jonatan");
			c2.setNombreDuenio("Godio");
			c3.setNombreDuenio("Julian");
			
			service.newAccout(c1);
			service.newAccout(c2);
			service.newAccout(c3);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

}
