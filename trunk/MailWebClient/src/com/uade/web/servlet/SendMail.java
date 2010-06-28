package com.uade.web.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.uade.mail.beans.MailVO;
import com.uade.mail.interfaces.MailService;
import com.uade.web.util.AccesoRMI;

/**
 * Servlet implementation class SendMail
 */
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService model;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Nothing to do
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("inputFrom");
		String to = request.getParameter("inputTo");
		String subject = request.getParameter("inputSubject");
		String body = request.getParameter("inputBody");
		
		
		model = (MailService) AccesoRMI.getInstance().getServiceInterface();		
		
		//DTO
		MailVO m = new MailVO();
		m.setFrom(from);
		m.setTo(to);
		m.setMessage(body);
		m.setSubject(subject);
		m.setSentDate(new Date());
		
		model.sendEmail(m);
		
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher("/inbox.jsp");
	    request.setAttribute("msg", "Mail enviado correctamente");
	    rd.forward(request, response);
	}

}
