package com.uade.mail.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Estado;
import com.uade.mail.beans.Mail;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.utils.PasswordEncrypt;

public class MailServiceImpl extends UnicastRemoteObject implements MailService{
	
	

	/**
	 * STATIC 
	 */
	
	private static final long serialVersionUID = -210094816812915149L;
	
	
	
	/**
	 * Model
	 */
	private ArrayList<Casilla> usuarios;
	private ArrayList<OficinaDeCorreo> oficinas;
	
	
	protected MailServiceImpl() throws RemoteException {
		super();
		usuarios = new ArrayList<Casilla>();
		oficinas = new ArrayList<OficinaDeCorreo>();
	}
	
	
	@Override
	public void addTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws RemoteException {
		//TODO
		System.out.println("Method invocation [addTrustedLink]");
		
	}
	
	@Override
	public void deleteTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws RemoteException {
		//TODO
		System.out.println("Method invocation [deleteTrutedLink]");
		
	}

	@Override
	public void deleteAccount(Casilla c) throws RemoteException {
		System.out.println("Method invocation [deleteAccount]");
		this.usuarios.remove(c);
	}

	@Override
	public void deleteOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [deleteOffice]");
		this.oficinas.remove(o);
	}


	@Override
	public void modifAccout(Casilla c) throws RemoteException {
		System.out.println("Method invocation [modifAccount]");
		if(this.usuarios.contains(c)){//si la casilla ya existe
			this.usuarios.remove(c);//borramos el viejo
			this.usuarios.add(c);//agregamos el nuevo
			//esto solo funciona si tienen el hashcode y el 
			//equals con el id que va a usar en la base
		}
	}

	@Override
	public void modifOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [modifOffice]");
		if(this.oficinas.contains(o)){
			this.oficinas.remove(o);
			this.oficinas.add(o);
		}
			
	}

	@Override
	public void modifPassword(Casilla c, String p) throws RemoteException {
		System.out.println("Method invocation [modifPassword]");
		this.usuarios.get(this.usuarios.indexOf(c)).setPassword(PasswordEncrypt.generateMD5(p));
	}

	@Override
	public void newAccout(Casilla c) throws RemoteException {
		System.out.println("Method invocation [newAccount]");
		this.usuarios.add(c);
	}

	@Override
	public void newOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [newOffice]");
		this.oficinas.add(o);
	}

	@Override
	public void sendEmail(Mail m) throws RemoteException {
		System.out.println("Method invocation [sendEmail]");
		//SEND MAIL
		Casilla from = m.getFrom();
		Casilla to = m.getTo();
		from.getInbox().getEstadoInbox().put(m, Estado.UNREAD);
		to.getInbox().getEstadoInbox().put(m, Estado.SENT);
		LogMensajes.getInstance().addMessage(m);
	}

	@Override
	public ArrayList<Mail> updateInbox(Casilla c) throws RemoteException {
		System.out.println("Method invocation [updateInbox]");
		return null;
	}

	@Override
	public ArrayList<Casilla> getContacts(Casilla c) throws RemoteException {
		System.out.println("Method invocation [getContacts]");
		return null;
	}


	@Override
	public ArrayList<Casilla> getAllAccounts() throws RemoteException {
		return this.usuarios;
	}


	@Override
	public ArrayList<OficinaDeCorreo> getAllOfices() throws RemoteException {
		return this.oficinas;
	}
	

	
}
