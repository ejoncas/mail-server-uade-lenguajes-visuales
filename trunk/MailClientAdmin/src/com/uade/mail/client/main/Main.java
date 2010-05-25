package com.uade.mail.client.main;

import java.rmi.RemoteException;
import java.util.Vector;

import com.uade.mail.interfaces.MailService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MailService service = MailClient.getInstance().getServiceInterface();
		
	}

}

