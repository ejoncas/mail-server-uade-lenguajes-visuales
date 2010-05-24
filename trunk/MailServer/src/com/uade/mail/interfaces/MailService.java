package com.uade.mail.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.MailVO;
import com.uade.mail.beans.OficinaDeCorreoVO;
import com.uade.mail.beans.UsuarioVO;


public interface MailService extends Remote{

	
	/**
	 * Actualizar Casilla en base a una cuenta 
	 * @param c
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<MailVO> updateInbox(CasillaVO c) throws RemoteException;
	
	/**
	 * Realiza el envio de un mensaje. Toda la info relevante para realizar 
	 * el envio se debe encontrar en el Mail (to, addres, from, etc)
	 * @param m
	 * @throws RemoteException
	 */
	public void sendEmail(MailVO m) throws RemoteException;
	
	/**
	 * Se encarga de crear una nueva cuenta de mail.
	 * @param c
	 * @throws RemoteException
	 */
	public void newAccout(CasillaVO c) throws RemoteException;
	/**
	 * Modifica la password de un usuario
	 * @param c
	 * @param p
	 * @throws RemoteException
	 */
	public void modifPassword(CasillaVO c, String p) throws RemoteException;
	
	/**
	 * Elimina una cuenta
	 * @param c
	 * @throws RemoteException
	 */
	public void deleteAccount(CasillaVO c) throws RemoteException;
	
	/**
	 * Modifica una cuenta de correo (La pisa)
	 * @param c
	 * @throws RemoteException
	 */
	public void modifAccout(CasillaVO c) throws RemoteException;
	
	/**
	 * Crea una oficina de correo
	 * @param o
	 * @throws RemoteException
	 */
	public void newOffice(OficinaDeCorreoVO o) throws RemoteException;
	
	/**
	 * Elimina una oficina de correo
	 * @param o
	 * @throws RemoteException
	 */
	public void deleteOffice(OficinaDeCorreoVO o) throws RemoteException;
	
	/**
	 * Modifica una Oficina de Correo
	 * @param o
	 * @throws RemoteException
	 */
	public void modifOffice(OficinaDeCorreoVO o) throws RemoteException;
	
	/**
	 * Agrega una relacion de confianza entre un par de Oficinas de Correo
	 * @param o1
	 * @param o2
	 * @throws RemoteException
	 */
	public void addTrustedLink(OficinaDeCorreoVO o1, OficinaDeCorreoVO o2) throws RemoteException;
	
	/**
	 * Elimina una relacion de confianza entre un par de Oficinas de Correo, si no
	 * existe la relacion, no hace nada.
	 * @param o1
	 * @param o2
	 * @throws RemoteException
	 */
	public void deleteTrustedLink(OficinaDeCorreoVO o1, OficinaDeCorreoVO o2) throws RemoteException;
	
	
	/**
	 * Obtiene toda la lista de contactos para una determinada casilla basandose
	 * en la oficina de correo a la(s) que pertenece y las relaciones de confianza
	 * involucradas
	 * @param c
	 * @throws RemoteException
	 */
	public ArrayList<CasillaVO> getContacts(CasillaVO c) throws RemoteException;
	
	public ArrayList<CasillaVO> getAllAccounts() throws RemoteException;
	
	public ArrayList<OficinaDeCorreoVO> getAllOfices() throws RemoteException;
	
	public ArrayList<UsuarioVO> getAllUsers() throws RemoteException;
	
	public void addNewUser(UsuarioVO user) throws RemoteException;

	public void modifUser(UsuarioVO user) throws RemoteException;
	
	public void removeUser(UsuarioVO user) throws RemoteException;
	
	
	//TODO - Log Interface
	//TODO - Alerts Interface
	
	
}
