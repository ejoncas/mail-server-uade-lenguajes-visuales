package com.uade.mail.client.main;

import com.uade.mail.interfaces.MailService;

public class Main {

	public static void main(String[] args) {

		MailService service = MailClient.getInstance().getServiceInterface();
		
	}

}

