package com.uade.mail.interfaces;

import java.util.ArrayList;


import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.exceptions.MailServiceException;

public interface MailService {

	
	/**
	 * Actualizar Casilla en base a una cuenta 
	 * @param c
	 * @return
	 * @throws MailServiceException
	 */
	public ArrayList<Mail> updateInbox(Casilla c) throws MailServiceException;
	
	/**
	 * Realiza el envio de un mensaje. Toda la info relevante para realizar 
	 * el envio se debe encontrar en el Mail (to, addres, from, etc)
	 * @param m
	 * @throws MailServiceException
	 */
	public void sendEmail(Mail m) throws MailServiceException;
	
	/**
	 * Se encarga de crear una nueva cuenta de mail.
	 * @param c
	 * @throws MailServiceException
	 */
	public void newAccout(Casilla c) throws MailServiceException;
	/**
	 * Modifica la password de un usuario
	 * @param c
	 * @param p
	 * @throws MailServiceException
	 */
	public void modifPassword(Casilla c, String p) throws MailServiceException;
	
	/**
	 * Elimina una cuenta
	 * @param c
	 * @throws MailServiceException
	 */
	public void deleteAccount(Casilla c) throws MailServiceException;
	
	/**
	 * Modifica una cuenta de correo (La pisa)
	 * @param c
	 * @throws MailServiceException
	 */
	public void modifAccout(Casilla c) throws MailServiceException;
	
	/**
	 * Crea una oficina de correo
	 * @param o
	 * @throws MailServiceException
	 */
	public void newOffice(OficinaDeCorreo o) throws MailServiceException;
	
	/**
	 * Elimina una oficina de correo
	 * @param o
	 * @throws MailServiceException
	 */
	public void deleteOffice(OficinaDeCorreo o) throws MailServiceException;
	
	/**
	 * Modifica una Oficina de Correo
	 * @param o
	 * @throws MailServiceException
	 */
	public void modifOffice(OficinaDeCorreo o) throws MailServiceException;
	
	/**
	 * Agrega una relacion de confianza entre un par de Oficinas de Correo
	 * @param o1
	 * @param o2
	 * @throws MailServiceException
	 */
	public void addTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2) throws MailServiceException;
	
	/**
	 * Elimina una relacion de confianza entre un par de Oficinas de Correo, si no
	 * existe la relacion, no hace nada.
	 * @param o1
	 * @param o2
	 * @throws MailServiceException
	 */
	public void deleteTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2) throws MailServiceException;
	
	
	//TODO - Log Interface
	//TODO - Alerts Interface
	
	
}
