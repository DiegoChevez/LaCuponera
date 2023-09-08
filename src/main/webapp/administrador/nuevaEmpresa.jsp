<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// Verifica si la sesión existe y si tiene el rol ADGRL-1586
String role = (String) session.getAttribute("role_id");
if (role == null || !"ADMIN-7874".equals(role)) {
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
					action="${pageContext.request.contextPath}/administradorGEO.do"
					method="POST">
					<input type="hidden" name="op" value="insertar">
					<div class="well well-sm">
						<strong><span class="glyphicon
glyphicon-asterisk"></span>Campos
							requeridos</strong>
					</div>
					<div class="form-group">


						<div class="form-group">
							<label for="codigo">codigo empresa</label>
							<div class="input-group">
								<input type="text" class="form-control" name="codigoE"
									id="codigoE" placeholder="Ingresa el codigo del autor">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>


						<div class="form-group">
							<label for="nombre">Nombre de la empresa</label>
							<div class="input-group">
								<input type="text" class="form-control" name="nombreE"
									id="nombre" placeholder="Ingresa el nombre del autor">
								<span class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label for="nombre">Nombre de la empresa corto</label>
							<div class="input-group">
								<input type="text" class="form-control" name="nombreES"
									id="nombre" placeholder="Ingresa el nombre del autor">
								<span class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>

						<div class="form-group">
							<label for="nombre">Direccion de la empresa</label>
							<div class="input-group">
								<input type="text" class="form-control" name="dir" id="nombre"
									placeholder="Ingresa el nombre del autor"> <span
									class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>


						<div class="form-group">
							<label for="nombre">Nombre contacto contacto</label>
							<div class="input-group">
								<input type="text" class="form-control" name="nombreCon"
									id="nombre" placeholder="Ingresa el nombre del autor">
								<span class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>

						<div class="form-group">
							<label for="nombre">Telefono</label>
							<div class="input-group">
								<input type="text" class="form-control" name="tel" id="nombre"
									placeholder="Ingresa el nombre del autor"> <span
									class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>

						<div class="form-group">
							<label for="nombre">Correo</label>
							<div class="input-group">
								<input type="text" class="form-control" name="correo"
									id="nombre" placeholder="Ingresa el nombre del autor">
								<span class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>


						<div class="form-group">
							<label for="rubro">Rubro</label>
							<div class="input-group">
								<select class="form-control" name="rubro" id="rubro">
									<option value="">Selecciona un rubro</option>
									<c:forEach items="${listaRubros}" var="unRubro">
										<option value="${unRubro.id}">${unRubro.nombreRubro}</option>
									</c:forEach>
								</select> <span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>


						<div class="form-group">
							<label for="nombre">Porcentaje</label>
							<div class="input-group">
								<input type="text" class="form-control" name="porcentaje"
									id="nombre" placeholder="Ingresa el nombre del autor">
								<span class="input-group-addon"><span
									class="glyphicon
glyphicon-asterisk"></span></span>
							</div>
						</div>

						<input type="submit" class="btn btn-info" value="Guardar"
							name="Guardar"> <a class="btn btn-danger"
							href="${pageContext.request.contextPath}/administradorGR.do?op=listar">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>