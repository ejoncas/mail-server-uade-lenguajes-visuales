package com.uade.mail.client.main;

import java.rmi.RemoteException;
import java.util.Vector;

import com.uade.mail.client.controller.MenuFrameController;
import com.uade.mail.client.views.MenuFrame;
import com.uade.mail.interfaces.MailService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MenuFrameController controlador = new MenuFrameController();
		new MenuFrame(controlador).setVisible(true);
		
	}

}

