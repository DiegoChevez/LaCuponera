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
					action="${pageContext.request.contextPath}/administradorGR.do"
					method="POST">
					<input type="hidden" name="op" value="modificar" />
					<div class="well well-sm">
						<strong><span class="glyphicon
glyphicon-asterisk"></span>Campos
							requeridos</strong>
					</div>
					<div class="form-group">

						<label for="codigo">Codigo del autor</label>
						<div class="input-group">
							<input type="text" class="form-control" name="codigo" id="codigo"
								value="${rubro.id}" readonly
								placeholder="Ingresa el codigo del
autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="nombre">Nombre del autor</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${rubro.nombreRubro}"
								placeholder="Ingresa el nombre del autor"> <span
								class="input-group-addon"><span
								class="glyphicon
glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
    <div class="form-group">
    <label for="estatusRubro">Estatus del Rubro:</label>
    <div class="input-group">
        <select class="form-control" id="estatusRubro" name="estatus">
            <option value="INACTIVA" ${rubro.estatusRubro == 'INACTIVA' ? 'selected' : ''}>INACTIVA</option>
            <option value="ACTIVA" ${rubro.estatusRubro == 'ACTIVA' ? 'selected' : ''}>ACTIVA</option>
        </select>
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