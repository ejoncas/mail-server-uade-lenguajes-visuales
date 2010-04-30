package com.uade.mail.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.uade.mail.interfaces.MailService;

public class MailServer {

	public static String SERVICE_URL = "//localhost/MailService";

	public static void publicarServicioMail() {
		try {
			LocateRegistry.createRegistry(1099);
			MailService mailService = new MailServiceImpl();
			Naming.rebind(SERVICE_URL, mailService);
			System.out.println("Servidor de Mail fijado en "+SERVICE_URL+" vía RMI");
		} catch (RemoteException e) {
			System.out.println("Ocurrio una exceción de RMI: "+e.getMessage());
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("Ocurrio una excepción con la URL donde alocar el RMI: "+e.getMessage());
			e.printStackTrace();
		}

	}

}
