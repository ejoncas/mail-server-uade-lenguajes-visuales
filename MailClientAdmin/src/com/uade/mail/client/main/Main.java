package com.uade.mail.client.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.uade.mail.interfaces.MailService;
import com.uade.mail.server.MailServer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			MailService mailService = (MailService) Naming.lookup(MailServer.SERVICE_URL);
			mailService.deleteAccount(null);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
