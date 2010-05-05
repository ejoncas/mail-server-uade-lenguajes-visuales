package com.uade.mail.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.beans.OficinaDeCorreo;


public interface MailService extends Remote{

	
	/**
	 * Actualizar Casilla en base a una cuenta 
	 * @param c
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Mail> updateInbox(Casilla c) throws RemoteException;
	
	/**
	 * Realiza el envio de un mensaje. Toda la info relevante para realizar 
	 * el envio se debe encontrar en el Mail (to, addres, from, etc)
	 * @param m
	 * @throws RemoteException
	 */
	public void sendEmail(Mail m) throws RemoteException;
	
	/**
	 * Se encarga de crear una nueva cuenta de mail.
	 * @param c
	 * @throws RemoteException
	 */
	public void newAccout(Casilla c) throws RemoteException;
	/**
	 * Modifica la password de un usuario
	 * @param c
	 * @param p
	 * @throws RemoteException
	 */
	public void modifPassword(Casilla c, String p) throws RemoteException;
	
	/**
	 * Elimina una cuenta
	 * @param c
	 * @throws RemoteException
	 */
	public void deleteAccount(Casilla c) throws RemoteException;
	
	/**
	 * Modifica una cuenta de correo (La pisa)
	 * @param c
	 * @throws RemoteException
	 */
	public void modifAccout(Casilla c) throws RemoteException;
	
	/**
	 * Crea una oficina de correo
	 * @param o
	 * @throws RemoteException
	 */
	public void newOffice(OficinaDeCorreo o) throws RemoteException;
	
	/**
	 * Elimina una oficina de correo
	 * @param o
	 * @throws RemoteException
	 */
	public void deleteOffice(OficinaDeCorreo o) throws RemoteException;
	
	/**
	 * Modifica una Oficina de Correo
	 * @param o
	 * @throws RemoteException
	 */
	public void modifOffice(OficinaDeCorreo o) throws RemoteException;
	
	/**
	 * Agrega una relacion de confianza entre un par de Oficinas de Correo
	 * @param o1
	 * @param o2
	 * @throws RemoteException
	 */
	public void addTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2) throws RemoteException;
	
	/**
	 * Elimina una relacion de confianza entre un par de Oficinas de Correo, si no
	 * existe la relacion, no hace nada.
	 * @param o1
	 * @param o2
	 * @throws RemoteException
	 */
	public void deleteTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2) throws RemoteException;
	
	
	/**
	 * Obtiene toda la lista de contactos para una determinada casilla basandose
	 * en la oficina de correo a la(s) que pertenece y las relaciones de confianza
	 * involucradas
	 * @param c
	 * @throws RemoteException
	 */
	public ArrayList<Casilla> getContacts(Casilla c) throws RemoteException;
	
	public ArrayList<Casilla> getAllAccounts() throws RemoteException;
	
	public ArrayList<OficinaDeCorreo> getAllOfices() throws RemoteException;
	
	//TODO - Log Interface
	//TODO - Alerts Interface
	
	
}
