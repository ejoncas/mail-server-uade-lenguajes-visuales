package com.uade.mail.client.main;

import com.uade.mail.client.controller.MenuFrameController;
import com.uade.mail.client.views.LoginAdmin;

public class Main {

	public static void main(String[] args) {

		MenuFrameController controlador = new MenuFrameController();
		//new MenuFrame(controlador).setVisible(true);
		
		//Creo un usuario, ya que la base esta vacia...
		//Generalmente en produccion, el "instalador" crea
		//un usuario admin por defecto
		
		
		controlador.crearUsuarioAdm("admin", "admin");
		
		new LoginAdmin(controlador).setVisible(true);
	
	}

}

