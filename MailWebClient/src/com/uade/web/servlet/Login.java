package com.uade.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uade.beans.entities.Casilla;
import com.uade.mail.interfaces.MailService;
import com.uade.web.util.AccesoRMI;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MailService model;
	private String LOGIN_FAILED = "/login.jsp";
	private String LOGIN_OK = "/inbox.jsp";
	

	/**
	 * el constructor no se llama en un Servlet.. los instancia solo el tomcat.
	 * 
	 * public Login() { //TODO: Contemplar que el RMI/Server esté caido y no se
	 * pueda conectar model = (MailService)
	 * AccesoRMI.getInstance().getServiceInterface(); }
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Nothing to do
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model = (MailService) AccesoRMI.getInstance().getServiceInterface();
		
		Casilla casillaLogueada = model.loginAccount(request.getParameter("usuario")+request.getParameter("domain"), request.getParameter("passwd"));
		
		if(casillaLogueada==null){//no se pudo loguear el usuario. Redirec Login
			request.setAttribute("error", "Usuario y o contraseña inválido");
			ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(LOGIN_FAILED);
		    rd.forward(request, response);
		}else{//casilla logueada. Redirect to inbox
			request.setAttribute("user", casillaLogueada);//Agregamos el usuario a la sesion
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(LOGIN_OK);
		    rd.forward(request, response);
		}
		
	}

}