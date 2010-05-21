package com.uade.mail.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.OficinaDeCorreoVO;
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
	
	public ArrayList<CasillaVO> getAccounts(){
		try {
			return this.model.getAllAccounts();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las casillas");
			return null;
		}
	}
	
	public ArrayList<OficinaDeCorreoVO> getOffices(){
		try{
			return this.model.getAllOfices();
		}catch (RemoteException e){
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las oficinas");
			return null;
		}
	}

	public void crearCuenta(String nombreCuenta, String nombreUsuario, char[] password) {
		CasillaVO c = new CasillaVO();
		//TODO - Verificar el max de caracteres - Preferentemente en la ventana
		// TODO - Adaptar a la nueva clase usuario. Dbeeria preguntar cuando
		// crees crear una cuenta si es para un usuario nuevo o un usuario
		// existente... De ahi saldrían dos metodos al controlador, uno que
		// reciba un usuario, y otro que reciba la data del usuario para crearlo
		c.setNombre(nombreCuenta+"@"+CasillaVO.SERVER_DOMAIN);
		//c.setNombreDuenio(nombreUsuario);
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
