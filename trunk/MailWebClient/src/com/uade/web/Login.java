package com.uade.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MailService model;
    
	public Login() {
		//TODO: Contemplar que el RMI/Server esté caido y no se pueda conectar
		model = (MailService) AccesoRMI.getInstance().getServiceInterface();		    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String usuario;
		 String clave;
		 
		 usuario = request.getParameter("usuario");
		 clave = request.getParameter("passwd");
		 
		 System.out.println("El usuario que ingreso es: "+usuario);
		 System.out.println("La clave que ingreso es : "+clave);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}