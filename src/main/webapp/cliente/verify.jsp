<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<span>Hemos enviado un codigo de verificación</span>

	<form action="${pageContext.request.contextPath}/VerifyCode" method="post">
		<input type="text" name="authcode">
		<input type="submit" value="verify">
	</form>
</body>
</html>