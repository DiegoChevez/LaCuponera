<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Destruye la sesión si existe
    session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Autenticación fallida. Por favor, verifica tus credenciales.</p>
    <% } %>
    
    <form action="${pageContext.request.contextPath}/LoginController" method="post">
        <label>Email:</label>
        <input type="text" name="email"><br>
        <label>Contraseña:</label>
        <input type="password" name="password"><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
</body>
</html>