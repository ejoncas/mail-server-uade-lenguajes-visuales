<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<script type="text/javascript">

$(document).ready(function(){

	//Page initialization

	$("#loginButton").click(function(){
			validarLogin();		
	});
	
	$(":input[type=button]").button();
	
});
</script>
		<FORM id="loginForm" ACTION="Login" METHOD="POST">
		<div align="center"">
		<div><input type="hidden" value="@lenguajes.edu.ar" name="domain"/></div>
			<table>	
			<thead>
				<tr>
					<th colspan="2">Ingrese Usuario y Password</th>
				</tr>
				<%if(request.getAttribute("error")!=null){%>
				<tr>
					<th colspan="2"><div class="error"><%=request.getAttribute("error") %></div></th>
				</tr>
				<%} %>	
			</thead>
			<tbody>
			<tr>
			<td>Usuario : </td><td><INPUT TYPE="text" ID="usuario" NAME="usuario">@lenguajes.edu.ar</td>
			</tr>
			<tr>
			<td>Password: </td><td><INPUT TYPE="password" ID="passwd" NAME="passwd"></td>
			</tr>
			<tr>
				<td></td>
				<td><INPUT TYPE="button" id="loginButton" VALUE="Login"/></td>
			</tr>
			</tbody>
			</table>
		</div>
		</FORM>
</body>
</html>