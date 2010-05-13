package com.uade.mail.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.client.main.MailClient;
import com.uade.mail.client.views.MenuFrame;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.utils.PasswordEncrypt;

public class MenuFrameController {
	
	public MailService model;
	public MenuFrame frame;
	
	public MenuFrameController(){
		model = MailClient.getInstance().getServiceInterface();
		frame = new MenuFrame(this);
	}
	
	public ArrayList<Casilla> getAccounts(){
		try {
			return this.model.getAllAccounts();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las casillas");
			return null;
		}
	}
	
	public ArrayList<OficinaDeCorreo> getOffices(){
		try{
			return this.model.getAllOfices();
		}catch (RemoteException e){
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las oficinas");
			return null;
		}
	}

	public void crearCuenta(String nombreCuenta, String nombreUsuario, char[] password) {
		Casilla c = new Casilla();
		//TODO - Verificar el max de caracteres - Preferentemente en la ventana
		c.setNombre(nombreCuenta+"@"+Casilla.SERVER_DOMAIN);
		c.setNombreDuenio(nombreUsuario);
		c.setPassword(PasswordEncrypt.generateMD5(charArrayToString(password)));
		try {
			model.newAccout(c);
		} catch (RemoteException e) {
			System.out.println("No se pudo agregar una " +
					"nueva cuenta desde la ventana de Nuevo Usuario");
			e.printStackTrace();
		}
	}
	
	private String charArrayToString(char[] a){
		String r="";
		for(char b : a)
			r+=b;
		return r;
	}

	
	
}
