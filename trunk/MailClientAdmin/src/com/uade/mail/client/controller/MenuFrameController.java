package com.uade.mail.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.client.main.MailClient;
import com.uade.mail.client.views.MenuFrame;
import com.uade.mail.interfaces.MailService;

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

	
	
}
