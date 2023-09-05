<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Verifica si la sesión existe y si tiene el rol ADGRL-1586
String role = (String) session.getAttribute("role");
if (role == null || !"ADGRL-1586".equals(role)) {
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

	<a class="btn btn-primary"
		href="${pageContext.request.contextPath}/administradorGR.do?op=listar"><span
		class="glyphicon glyphicon-edit"></span> Gestionar rubros</a>
		
	<a class="btn btn-primary"
		href="${pageContext.request.contextPath}/administradorGC.do?op=listar"><span
		class="glyphicon glyphicon-edit"></span> Gestionar </a>
</body>
</html>