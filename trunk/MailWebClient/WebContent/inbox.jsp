<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.uade.beans.entities.Casilla"%>

<%@page import="com.uade.mail.beans.MailVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<%
	Casilla user = (Casilla) request.getSession().getAttribute("user");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
%>

<%
	if (user != null) {
%>
<script type="text/javascript">
	$( function() {
		//Page Initialization
		$("#lnkInbox").addClass("selected");

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
		<h2>Recibidos</h2>
		<%
			if (request.getAttribute("msg") != null) {
		%>
		<div class="msg"><%=request.getAttribute("msg")%></div>
		<%
			}
		%>
		<table class="mailTable">
			<thead>
				<tr>
					<th>From</th>
					<th width="50%">Subject</th>
					<th>Received Date</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (MailVO n : (List<MailVO>) request.getSession().getAttribute("noLeidos")) {
							String snippet = n.getSubject()+ " - "+ (n.getMessage().length() < 25 ? n.getMessage()
											: n.getMessage().substring(0, 25)) + "...";
				%>
				<tr class="unread">
					<td><%=n.getFrom()%></td>
					<td width="50%"><a href="VerMail?mailid=<%=n.getId()%>"><%=snippet%></a></td>
					<td><%=formatter.format(n.getSentDate())%></td>
				</tr>
				<%
					}
				%>
				<%
					for (MailVO l : (List<MailVO>) request.getSession().getAttribute("leidos")) {
							String snippet = l.getSubject()+ " - "+ (l.getMessage().length() < 25 ? l.getMessage()
											: l.getMessage().substring(0, 25)) + "...";
				%>
				<tr>
					<td><%=l.getFrom()%></td>
					<td width="50%"><a href="VerMail?mailid=<%=l.getId()%>"><%=snippet%></a></td>
					<td><%=formatter.format(l.getSentDate())%></td>
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
<%
	} else {
		request.setAttribute("error", "Debe noguearse en en sistema");
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/nogin.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>