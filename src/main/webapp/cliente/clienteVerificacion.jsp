<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Usuario Email</h1>
	<form action="${pageContext.request.contextPath}/UserVerify" method="post">
		<label>User name:</label>
		<input type="text" name="username">
		<label>User mail:</label>
		<input type="email" name="usermail">
		<input type="submit" value="Register">
	</form>
</body>
</html>