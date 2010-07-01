<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.uade.beans.entities.Casilla"%>
<%@page import="com.uade.mail.beans.MailVO"%>
<html>
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
			
		$("#bloquearUsuario").click(function(){
			$("#bloquearUsuario").attr('src','img/ajax-loader.gif');
			AjaxHelper.blockUser('<%=user.getNombre()%>', '<%=verMail.getFrom()%>', function() {
																alert('usuario bloqueado satisfactoriamente');
																$("#bloquearUsuario").remove();
								});
			});

						$("#bloquearUsuario").qtip( {
							content : 'Bloquear Usuario',
							show : 'mouseover',
							hide : 'mouseleave',
							position : {
								corner : {
									target : 'topRight',
									tooltip : 'bottomLeft'
								}
							},
							style : {
								tip : {
									corner : 'bottomLeft',
									size : {
										x : 20,
										y : 8
									}
								},
								border : {
									width : 7,
									radius : 5
								},
								name : 'light' // Inherit from preset style
							}
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
		<h2><%="Subject: "+verMail.getSubject() %></h2>

		<table class="mailTable">
			<tr>
				<td>To:</td>
				<td style="text-align: left;">
				<%for(String s : verMail.getTo()){%>
				<%=s+"," %>	
				<%}%>
				</td>
			</tr>
			<tr>
				<td>From:</td>
				<td style="text-align: left;"><%=verMail.getFrom()%> <%if((Boolean)request.getAttribute("showBlock")){ %>
				<img alt="bloquear" src="img/delete.png" id="bloquearUsuario" /> <%} %>
				</td>
			</tr>
			<tr>
				<td>Body:</td>
				<td><textarea style="margin-left: -10%" name="inputBody"
					readonly="readonly" id="inputBody" rows="20" cols="100"><%=verMail.getMessage() %></textarea></td>
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