<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
// Verifica si la sesión existe y si tiene el rol ADGRL-1586
String role = (String) session.getAttribute("role_id");
String user_id = (String) session.getAttribute("user_id");
if (role == null || !"COMPY-2436".equals(role)) {
	// Si no tiene el rol, redirige al usuario al formulario de inicio de sesión
	response.sendRedirect(request.getContextPath() + "/index.jsp");
}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hola eo</h1>
</body>
</html>