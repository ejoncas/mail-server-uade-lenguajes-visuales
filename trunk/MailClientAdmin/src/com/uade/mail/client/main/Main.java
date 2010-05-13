package com.uade.mail.client.main;

import java.rmi.RemoteException;
import java.util.Vector;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.interfaces.MailService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MailService service = MailClient.getInstance().getServiceInterface();
		
	}

}

