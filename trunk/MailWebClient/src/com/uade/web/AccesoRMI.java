package com.uade.web;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.server.MailServer;

public class AccesoRMI {

	private static AccesoRMI instance = null;
	
	private MailService serviceInterface;
	
	private AccesoRMI(){
		try {
			serviceInterface = (MailService) Naming.lookup(MailServer.SERVICE_URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	

	public MailService getServiceInterface() {
		return serviceInterface;
	}



	public void setServiceInterface(MailService serviceInterface) {
		this.serviceInterface = serviceInterface;
	}



	//SINGLETON
	public static AccesoRMI getInstance(){
		if(instance==null)
			instance=new AccesoRMI();
		return instance;
	}
	
	
}
