package com.uade.mail.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.interfaces.MailService;

public class MailServiceImpl extends UnicastRemoteObject implements MailService{

	protected MailServiceImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -210094816812915149L;
	
	private static String SERVER_DOMAIN = "lenguajes.edu.ar";
	private static int MAX_CHARACTERS = 20;
	
	
	@Override
	public void addTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws RemoteException {
		System.out.println("Method invocation [addTrustedLink]");
		
	}

	@Override
	public void deleteAccount(Casilla c) throws RemoteException {
		System.out.println("Method invocation [deleteAccount]");
		
	}

	@Override
	public void deleteOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [deleteOffice]");
		
	}

	@Override
	public void deleteTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws RemoteException {
		System.out.println("Method invocation [deleteTrutedLink]");
		
	}

	@Override
	public void modifAccout(Casilla c) throws RemoteException {
		System.out.println("Method invocation [modifAccount]");
		
	}

	@Override
	public void modifOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [modifOffice]");
		
	}

	@Override
	public void modifPassword(Casilla c, String p) throws RemoteException {
		System.out.println("Method invocation [modifPassword]");
		
	}

	@Override
	public void newAccout(Casilla c) throws RemoteException {
		System.out.println("Method invocation [newAccount]");
		
	}

	@Override
	public void newOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [newOffice]");
		
	}

	@Override
	public void sendEmail(Mail m) throws RemoteException {
		System.out.println("Method invocation [sendEmail]");
		
	}

	@Override
	public HashSet<Mail> updateInbox(Casilla c) throws RemoteException {
		System.out.println("Method invocation [updateInbox]");
		return null;
	}

	@Override
	public HashSet<Casilla> getContacts(Casilla c) throws RemoteException {
		System.out.println("Method invocation [getContacts]");
		return null;
	}
	

	
}
