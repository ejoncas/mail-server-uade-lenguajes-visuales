<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.uade.beans.entities.Casilla"%>
<%@page import="java.util.List"%>
<%@page import="com.uade.mail.beans.MailVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.uade.web.util.JSPHelper"%><html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<%
	Casilla user = (Casilla)request.getSession().getAttribute("user");
	List<MailVO> mailsEliminados = JSPHelper.getListEliminados(user); 
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<%if(user!=null){ %>
<script type="text/javascript">
	$(function() {
		//Page Initialization
		$("#lnkEliminados").addClass("selected");
	});

</script>

<table class="panel" width="100%">
	<tr>
	
	<td width="20%">
		<div id="menuPanel">
				<p style="font-size: .8em">Bienvenido!<br/>
				<strong><%=user.getNombre()%></strong><br/>
				<a href="Logout">Logout</a></p><br/>
				
					<ul>
						<li><a id="lnkMail" href="nuevoMail.jsp">Nuevo Mail</a></li>
						<li><a id="lnkInbox" href="inbox.jsp">Recibidos</a></li>
						<li><a id="lnkEnviados" href="enviados.jsp">Enviados</a></li>
						<li><a id="lnkEliminados" href="eliminados.jsp">Eliminados</a></li>
					</ul>
		</div>	
	</td>
	
	<td>
		<div id="contentPanel">
			<h2>Eliminados</h2>
			<table class="mailTable">
			<thead>
				<tr>
					<th>From</th><th width="50%">Subject</th><th>Received Date</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (MailVO n : mailsEliminados) {
							String fullSnippet = n.getSubject()+ " - "+ n.getMessage();
							String snippet = fullSnippet.length()>60? fullSnippet.substring(0,60)+ "..." : fullSnippet;
				%>
				<tr>
					<td><%=n.getFrom()%></td>
					<td width="50%"><a href="VerMail?mailid=<%=n.getId()%>"><%=snippet%></a></td>
					<td><%=formatter.format(n.getSentDate())%></td>
				</tr>
				<%
					}
				%>
			</tbody>
			</table>
		</div>
	</td>
	
	</tr>
</table>
<%}else{ 
	request.setAttribute("error", "Debe Loguearse en el sistema");
	ServletContext sc = getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
    rd.forward(request, response);
} %>
</body>
</html>