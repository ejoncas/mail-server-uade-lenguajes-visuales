<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.uade.beans.entities.Casilla"%>
<%@page import="com.uade.mail.beans.MailVO"%><html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<%
	Casilla user = (Casilla) request.getSession().getAttribute("user");
	MailVO verMail = (MailVO) request.getSession().getAttribute("verMail");
%>

<%
	if (user != null) {
%>
<script type="text/javascript">
	$(document).ready(function() {

	});

</script>
<table class="panel" width="100%">
	<tr>

		<td width="20%">
		<div id="menuPanel">
		<p style="font-size: .8em">Bienvenido!<br />
		<strong><%=user.getNombre()%></strong><br />
		<a href="Logout">Logout</a></p>
		<br />

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
		<h2><%=verMail.getSubject() %></h2>
		
		<table class="mailTable">
			<tr>
				<td>To:</td>
				<td><input id="inputTo" name="inputTo" type="text" value="<%=verMail.getTo() %>"/></td>
			</tr>
			<tr>
				<td>From:</td>
				<td><input type="text" name="inputFrom" readonly="readonly"
					value="<%=verMail.getFrom()%>" /></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><input name="inputSubject" id="inputSubject" type="text" value="<%=verMail.getSubject()%>"/></td>
			</tr>
			<tr>
				<td>Body:</td>
				<td><textarea name="inputBody" id="inputBody" rows="20" cols="100" ><%=verMail.getMessage() %></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="btnEnviar" value="Enviar" /></td>
			</tr>
		</table>
		
		</div>
		</td>

	</tr>
</table>
<%
	} else {
		request.setAttribute("error", "Debe Loguearse en el sistema");
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>