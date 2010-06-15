package com.uade.mail.client.main;

import com.uade.mail.client.controller.MenuFrameController;
import com.uade.mail.client.views.MenuFrame;

public class Main {

	public static void main(String[] args) {

		MenuFrameController controlador = new MenuFrameController();
		new MenuFrame(controlador).setVisible(true);
		
		controlador.crearUsuarioAdm("sergio", "clave");
		
		controlador.validarUsuarioAdm("sergio", "clave");
	
	}

}

