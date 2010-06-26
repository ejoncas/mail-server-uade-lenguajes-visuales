package com.uade.mail.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.Mail;
import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.beans.entities.Usuario;
import com.uade.beans.entities.UsuarioAdm;
import com.uade.mail.beans.MailVO;


public interface MailService extends Remote{
	
	/** Crea un nuevo usuario Administrador
	 * 
	 * */
	public void newUserAdmin(UsuarioAdm u) throws RemoteException;
	
	/** Valida a un usuario administrado en base al usuario y clave hash.
	 * 
	 * */
	public boolean validoUsuarioAdm (String username, String claveMD5) throws RemoteException;
	
	/** Devuelve una lista con todos los usuarios administradores del sistema
	 * 
	*/
	public List<UsuarioAdm> getUsersAdmin() throws RemoteException;
	
	/** Borra un usuario administrador
	 * 
	 */
	public void deleteUserAdmin(Long ID) throws RemoteException;
	
	/** Modifica los parametros de un usuario administrador
	 * ID a modificar, nuevo usuario y/o nueva clave 
	*/
	public void editUserAdmin(Long ID, String username, String claveMD5) throws RemoteException;
	
	
	/**
	 * Actualizar Casilla en base a una cuenta 
	 * @param c
	 * @return
	 * @throws RemoteException
	 */
	public List<MailVO> updateInbox(Casilla c,String estado) throws RemoteException;
	
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
	public List<Casilla> getContacts(Casilla c) throws RemoteException;
	
	public List<Casilla> getAllAccounts() throws RemoteException;
	
	public List<OficinaDeCorreo> getAllOfices() throws RemoteException;
	
	public List<Usuario> getAllUsers() throws RemoteException;
	
	public void addNewUser(Usuario user) throws RemoteException;

	public void modifUser(Usuario user) throws RemoteException;
	
	public void removeUser(Usuario user) throws RemoteException;
	
	public List<OficinaDeCorreo> getTrustedOffices(OficinaDeCorreo o) throws RemoteException;

	public void clearTrustedLink(OficinaDeCorreo o) throws RemoteException;
	
	public Casilla loginAccount(String usuario, String password) throws RemoteException;
	
	public Casilla getCasillaByUsername(String username) throws RemoteException;
	//TODO - Log Interface
	//TODO - Alerts Interface
	
	
}
