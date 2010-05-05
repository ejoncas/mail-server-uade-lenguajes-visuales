package com.uade.mail.client.main;

import java.rmi.RemoteException;
import com.uade.mail.beans.Mail;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			MailClient.getInstance().getServiceInterface().sendEmail(new Mail());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

}
