package com.uade.mail.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.EstadoMailVO;
import com.uade.mail.beans.EstadosPosibles;
import com.uade.mail.beans.MailVO;
import com.uade.mail.beans.OficinaDeCorreoVO;
import com.uade.mail.beans.UsuarioVO;
import com.uade.mail.interfaces.MailService;

public class MailServiceImpl extends UnicastRemoteObject implements MailService{
	
	/**
	 * STATIC 
	 */
	
	private static final long serialVersionUID = -210094816812915149L;
	
	
	/**
	 * Model
	 */
	private ArrayList<CasillaVO> usuarios;
	private ArrayList<UsuarioVO> infoUsuarios;
	private ArrayList<OficinaDeCorreoVO> oficinas;
	
	
	protected MailServiceImpl() throws RemoteException {
		super();
		usuarios = new ArrayList<CasillaVO>();
		oficinas = new ArrayList<OficinaDeCorreoVO>();
		infoUsuarios = new ArrayList<UsuarioVO>();
	}
	
	
	@Override
	public void addTrustedLink(OficinaDeCorreoVO o1, OficinaDeCorreoVO o2)
			throws RemoteException {
		System.out.println("Method invocation [addTrustedLink]");
		for(OficinaDeCorreoVO o:oficinas)
			if(o.equals(o1))
				o.addOficinaDeCorreo(o2);
	}
	
	@Override
	public void deleteTrustedLink(OficinaDeCorreoVO o1, OficinaDeCorreoVO o2)
			throws RemoteException {
		//TODO
		System.out.println("Method invocation [deleteTrutedLink]");
		
	}

	@Override
	public void deleteAccount(CasillaVO c) throws RemoteException {
		System.out.println("Method invocation [deleteAccount]");
		this.usuarios.remove(c);
	}

	@Override
	public void deleteOffice(OficinaDeCorreoVO o) throws RemoteException {
		System.out.println("Method invocation [deleteOffice]");
		this.oficinas.remove(o);
	}


	@Override
	public void modifAccout(CasillaVO c) throws RemoteException {
		System.out.println("Method invocation [modifAccount]");
		if(this.usuarios.contains(c)){//si la casilla ya existe
			this.usuarios.remove(c);//borramos el viejo
			this.usuarios.add(c);//agregamos el nuevo
			//esto solo funciona si tienen el hashcode y el 
			//equals con el id que va a usar en la base
		}
	}

	@Override
	public void modifOffice(OficinaDeCorreoVO o) throws RemoteException {
		System.out.println("Method invocation [modifOffice]");
		if(this.oficinas.contains(o)){
			this.oficinas.remove(o);
			this.oficinas.add(o);
		}
			
	}

	@Override
	public void modifPassword(CasillaVO c, String p) throws RemoteException {
		System.out.println("Method invocation [modifPassword]");
		this.usuarios.get(this.usuarios.indexOf(c)).setPassword(p);
	}

	@Override
	public void newAccout(CasillaVO c) throws RemoteException {
		System.out.println("Method invocation [newAccount]");
		this.usuarios.add(c);
	}

	@Override
	public void newOffice(OficinaDeCorreoVO o) throws RemoteException {
		System.out.println("Method invocation [newOffice]");
		this.oficinas.add(o);
	}

	@Override
	public void sendEmail(MailVO m) throws RemoteException {
		System.out.println("Method invocation [sendEmail]");
		//SEND MAIL
		CasillaVO from = m.getFrom();
		CasillaVO to = m.getTo();
		EstadoMailVO estado1 = new EstadoMailVO();
		estado1.setMail(m);
		estado1.setEstado(EstadosPosibles.SENT);
		EstadoMailVO estado2 = new EstadoMailVO();
		estado2.setMail(m);
		estado2.setEstado(EstadosPosibles.UNREAD);
		
		from.getInbox().add(estado1);
		to.getInbox().add(estado2);
		
		LogMensajes.getInstance().addMessage(m);
	}

	@Override
	public ArrayList<MailVO> updateInbox(CasillaVO c) throws RemoteException {
		System.out.println("Method invocation [updateInbox]");
		return null;
	}

	@Override
	public ArrayList<CasillaVO> getContacts(CasillaVO c) throws RemoteException {
		System.out.println("Method invocation [getContacts]");
		return null;
	}


	@Override
	public ArrayList<CasillaVO> getAllAccounts() throws RemoteException {
		System.out.println("Method invocation [getAllAccounts]");
		return this.usuarios;
	}


	@Override
	public ArrayList<OficinaDeCorreoVO> getAllOfices() throws RemoteException {
		System.out.println("Method invocation [getAllOfices]");
		return this.oficinas;
	}


	@Override
	public void addNewUser(UsuarioVO user) throws RemoteException {
		System.out.println("Method invocation [addNewUser]");
		this.infoUsuarios.add(user);
	}


	@Override
	public ArrayList<UsuarioVO> getAllUsers() throws RemoteException {
		System.out.println("Method invocation [getAllUsers]");
		return this.infoUsuarios;
	}


	@Override
	public void modifUser(UsuarioVO user) throws RemoteException {
		//TODO - Update
		System.out.println("Method invocation [modifUser]");
	}


	@Override
	public void removeUser(UsuarioVO user) throws RemoteException {
		// TODO Delete
		System.out.println("Method invocation [removeUser]");
		this.infoUsuarios.remove(user);
	}
	

	
}
