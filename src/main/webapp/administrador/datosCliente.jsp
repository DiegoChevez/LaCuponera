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
					action="${pageContext.request.contextPath}/administradorGC.do"
					method="POST">
					<input type="hidden" name="op" value="modificar" />
					<div class="well well-sm">
						<strong><span class="glyphicon
glyphicon-asterisk"></span>Campos
							requeridos</strong>
					</div>
					<div class="form-group">

						<label for="codigo">Codigo de cliente</label>
						<div class="input-group">
							<input type="text" class="form-control" name="codigo" id="codigo"
								value="${rubro.customerId}" readonly
								placeholder="Ingresa el codigo del
autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Codigo del usuario</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.userId}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Nombreso</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.firstName}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>

					<div class="form-group">
						<label for="nombre">Apellidos</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.lastName}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Telefono</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.phoneC}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Email</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.mailC}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Direccion</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.addressC}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">DUI</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.duiC}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Status</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.statusC}" readonly
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>

					<a class="btn btn-danger" href="${pageContext.request.contextPath}/administradorGC.do?op=listarCD&codigo=${rubro.customerId}">Cupones Disponibles</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/administradorGC.do?op=listarCC&codigo=${rubro.customerId}">Cupones Canjeados</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/administradorGC.do?op=listarCV&codigo=${rubro.customerId}">Cupones Vencidos</a>
					<a class="btn btn-danger"
						href="${pageContext.request.contextPath}/administradorGC.do?op=listar">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>