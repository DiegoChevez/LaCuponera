<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Verifica si la sesión existe y si tiene el rol ADGRL-1586
String role = (String) session.getAttribute("role_id");
String user_id = (String) session.getAttribute("user_id");
if (role == null || !"ADMIN-7874".equals(role)) {
	// Si no tiene el rol, redirige al usuario al formulario de inicio de sesión
	response.sendRedirect(request.getContextPath() + "/index.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	<h2>Bienvenido al Panel de Administrador</h2>
	
	<p>Tu user_id es: <%= user_id %></p>
	<p>Tu rol es: <%= role %></p>

	<a class="btn btn-primary"
		href="${pageContext.request.contextPath}/administradorGR.do?op=listar"><span
		class="glyphicon glyphicon-edit"></span> Gestionar rubros</a>
		
	<a class="btn btn-primary"
		href="${pageContext.request.contextPath}/administradorGC.do?op=listar"><span
		class="glyphicon glyphicon-edit"></span> Gestionar </a>
</body>
</html>