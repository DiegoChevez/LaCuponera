<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<title>Nuevo autor</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<h3>Nuevo autor</h3>
		</div>
		<div class="row">
			<div class=" col-md-7">

				<c:if test="${not empty listaErrores}">
					<div class="alert alert-danger">
						<ul>
							<c:forEach var="errores" items="${requestScope.listaErrores}">
								<li>${errores}</li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<form role="form"
					action="${pageContext.request.contextPath}/administradorGR.do"
					method="POST">
					<input type="hidden" name="op" value="insertar">
					<div class="well well-sm">
						<strong><span class="glyphicon
glyphicon-asterisk"></span>Campos
							requeridos</strong>
					</div>
					<div class="form-group">

						<label for="codigo">Codigo del autor</label>
						<div class="input-group">
							<input type="text" class="form-control" name="id" id="codigo"
								
								placeholder="Ingresa el codigo del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Nombre del autor</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="contacto">Nacionalidad del autor:</label>
						<div class="input-group">
							<input type="hidden" class="form-control" id="contacto" value="APR1-45289"
								 name="estatus"
								placeholder="Ingresa la nacionalidad del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>

					<input type="submit" class="btn btn-info" value="Guardar"
						name="Guardar"> <a class="btn btn-danger"
						href="${pageContext.request.contextPath}/autores.do?op=listar">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>