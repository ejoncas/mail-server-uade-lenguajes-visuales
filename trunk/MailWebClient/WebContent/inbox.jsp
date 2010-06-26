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

		$("img[src='img/recycle.png']").click(function(){
			var idAEliminar = $(this).parent().children("input[type='hidden']").val();
			var e = $(this);
			$(this).attr('src','img/ajax-loader.gif');
			//TODO - Call Ajax
			AjaxHelper.removeMail(idAEliminar,'<%=user.getNombre()%>',function(){
				$(e).parent().parent().remove();
			});
		});
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
					<th width="3%">Eliminar</th>
					<th>From</th>
					<th width="50%">Subject</th>
					<th>Received Date</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (MailVO n : (List<MailVO>) request.getSession().getAttribute("noLeidos")) {
							String fullSnippet = n.getSubject()+ " - "+ n.getMessage();
							String snippet = fullSnippet.length()>60? fullSnippet.substring(0,60)+ "..." : fullSnippet;
				%>
				<tr class="unread">
					<td><img alt="borrarMensaje" src="img/recycle.png"> <input type="hidden" value="<%=n.getId()%>"/></td>
					<td><%=n.getFrom()%></td>
					<td width="50%"><a href="VerMail?mailid=<%=n.getId()%>"><%=snippet%></a></td>
					<td><%=formatter.format(n.getSentDate())%></td>
				</tr>
				<%
					}
				%>
				<%
					for (MailVO l : (List<MailVO>) request.getSession().getAttribute("leidos")) {
						String fullSnippet = l.getSubject()+ " - "+ l.getMessage();
						String snippet = fullSnippet.length()>60? fullSnippet.substring(0,60)+ "..." : fullSnippet;
				%>
				<tr>
					<td><img alt="borrarMensaje" src="img/recycle.png"><input type="hidden" value="<%=l.getId()%>"/></td>
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