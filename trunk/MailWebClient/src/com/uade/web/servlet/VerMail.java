package com.uade.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.EstadosPosibles;
import com.uade.mail.beans.MailVO;
import com.uade.mail.interfaces.MailService;
import com.uade.web.util.AccesoRMI;
import com.uade.web.util.JSPHelper;

/**
 * Servlet implementation class VerMail
 */
public class VerMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService model;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long mailid = Long.parseLong(request.getParameter("mailid"));
		
		List<MailVO> leidos = (List<MailVO>) request.getSession().getAttribute("leidos");
		List<MailVO> noLeidos =(List<MailVO>) request.getSession().getAttribute("noLeidos");
		
		MailVO verMail = null;
		
		boolean eraLeido = false;
		
		for(int i = 0 ; i<leidos.size() && verMail==null; i++){
			if(leidos.get(i).getId().equals(mailid)){
				verMail = leidos.get(i);//quiere ver un leido
				eraLeido = true;
			}
		}
		
		for(int i = 0 ; i<noLeidos.size() && verMail==null; i++){
			if(noLeidos.get(i).getId().equals(mailid)){
				verMail = noLeidos.get(i);//quiere ver uno nuevo
			}
		}
		
		boolean showBlock = true;
		if(verMail==null){//buscar en enviados
			for(MailVO vo : JSPHelper.getListaEnviados(((Casilla)request.getSession().getAttribute("user"))))
				if(vo.getId().equals(mailid)){//viene de enviados
					verMail = vo;
					showBlock=false;
				}
			if(verMail==null){//buscar en basura
				for(MailVO vo : JSPHelper.getListEliminados(((Casilla)request.getSession().getAttribute("user"))))
					if(vo.getId().equals(mailid)){//viene de basura
						verMail = vo;
						showBlock=false;
					}
			}
		}
		
		if(verMail!=null){
			request.getSession().setAttribute("verMail", verMail);
			if(!eraLeido){//hay que moverlo al vector de leidos, y avisarle al servidor que se leyó
				leidos.add(verMail);
				noLeidos.remove(verMail);
				model = (MailService) AccesoRMI.getInstance().getServiceInterface();
				Casilla user = (Casilla) request.getSession().getAttribute("user");
				model.changeEstadoMail(verMail, user.getNombre(), EstadosPosibles.READ);
			}
			ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher("/verMail.jsp");
	    	request.setAttribute("showBlock", showBlock);
		    rd.forward(request, response);
		}else{
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher("/inbox.jsp");
		    request.setAttribute("msg", "Error al intentar ver el mail");
		    rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Nothing to do
	}

}
