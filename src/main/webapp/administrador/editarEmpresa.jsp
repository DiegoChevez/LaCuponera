<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Modificar autor</title>
<%@ include file='/cabecera.jsp'%>
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<div class="container">
		<div class="row">
			<h3>Modificar autor</h3>
		</div>
		<div class="row">
			<div class="col-md-7">
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
					<input type="hidden" name="op" value="modificar" />
					<div class="well well-sm">
						<strong><span class="glyphicon glyphicon-asterisk"></span>
							Campos requeridos</strong>
					</div>
					<div class="form-group">
						<label for="codigo">Código del usuario</label>
						<div class="input-group">
							<input type="text" class="form-control" name="codigo" id="codigo"
								value="${empresa.usuarioId}" readonly
								placeholder="Ingresa el código del autor"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="codigo">Id de la empresa</label>
						<div class="input-group">
							<input type="text" class="form-control" name="idempresa"
								id="codigo" value="${empresa.idEmpresa}" readonly
								placeholder="Ingresa el código del autor"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<div class="form-group">
						<label for="nombre">Código de empresa</label>
						<div class="input-group">
							<input type="text" class="form-control" name="codigoempresa"
								id="nombre" value="${empresa.codigoEmpresa}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="shortName">Nombre</label>
						<div class="input-group">
							<input type="text" class="form-control" name="shortName"
								id="shortName" value="${empresa.shortName}"
								placeholder="Ingresa el Short Name"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="direccion">Dirección</label>
						<div class="input-group">
							<input type="text" class="form-control" name="direccion"
								id="direccion" value="${empresa.direccion}"
								placeholder="Ingresa la dirección"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombreContacto">Nombre de Contacto</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombreContacto"
								id="nombreContacto" value="${empresa.nombreContacto}"
								placeholder="Ingresa el nombre del contacto"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="telefono">Teléfono</label>
						<div class="input-group">
							<input type="text" class="form-control" name="telefono"
								id="telefono" value="${empresa.telefono}"
								placeholder="Ingresa el teléfono"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="correo">Correo</label>
						<div class="input-group">
							<input type="text" class="form-control" name="correo" id="correo"
								value="${empresa.correo}" placeholder="Ingresa el correo">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<div class="form-group">
						<label for="correo">Porcentaje</label>
						<div class="input-group">
							<input type="text" class="form-control" name="porcentaje"
								id="correo" value="${empresa.porcentaje}"
								placeholder="Ingresa el correo"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<div class="form-group">
						<label for="rubro">Rubro</label>
						<div class="input-group">
							<select class="form-control" name="rubro" id="rubro">
								<option value="">${rubro.nombreRubro}</option>
								<c:forEach items="${listaRubros}" var="rubro">
									<option value="${rubro.id}"
										${rubro.id == empresa.rubro ? 'selected' : ''}>${rubro.nombreRubro}</option>
								</c:forEach>
							</select> <span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>





					<div class="form-group">
						<label for="porcentaje">Status</label>
						<div class="input-group">
							<select class="form-control" name="status" id="porcentaje">
								<option value="activo"
									${empresa.porcentaje == 'activo' ? 'selected' : ''}>Activo</option>
								<option value="inactivo"
									${empresa.porcentaje == 'inactivo' ? 'selected' : ''}>Inactiva</option>
							</select> <span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<input type="submit" class="btn btn-info" value="Guardar"
						name="Guardar"> <a class="btn btn-danger"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listar">Cancelar</a>

					<td><a class="btn btn-primary"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listarOC&id=${empresa.idEmpresa}"><span
							class="glyphicon glyphicon-edit"></span> Listar Ofertas Activas</a> <!-- Vigentes -->
					<td><a class="btn btn-primary"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listarOP&id=${empresa.idEmpresa}"><span
							class="glyphicon glyphicon-edit"></span> Listar Ofertas Pasadas</a> <!-- Vencidas -->
					<td><a class="btn btn-primary"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listarEP&id=${empresa.idEmpresa}"><span
							class="glyphicon glyphicon-edit"></span> Listar Ofertas En Espera</a>
					<td><a class="btn btn-primary"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listarAP&id=${empresa.idEmpresa}"><span
							class="glyphicon glyphicon-edit"></span> Listar Ofertas Aprobadas</a>
					<td><a class="btn btn-primary"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listarRE&id=${empresa.idEmpresa}"><span
							class="glyphicon glyphicon-edit"></span> Listar Ofertas
							Rechazadas</a>
					<td><a class="btn btn-primary"
						href="${pageContext.request.contextPath}/administradorGEO.do?op=listarDE&id=${empresa.idEmpresa}"><span
							class="glyphicon glyphicon-edit"></span> Listar Ofertas
							Descartadas</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>