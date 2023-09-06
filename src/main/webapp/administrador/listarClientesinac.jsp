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
<title>Lista de Rubros</title>
<%@ include file='cabecera.jsp'%>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>Lista de Rubros</h3>
			<jsp:include page="menu.jsp" />
		</div>
		<div class="row">
			<div class="col-md-10">
				<a type="button" class="btn btn-primary btn-md"
					href="${pageContext.request.contextPath}/administradorGC.do?op=listinac">
					
					Listar Inactivos</a> <br /> <br />
				<table class="table table-striped table-bordered table-hover"
					id="tabla">
					<thead>
						<tr>
							<th>Id del rubro</th>
							<th>Nombre del Rubro</th>
							<th>Estado</th>
							<th>Operaciones</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${requestScope.listaClientes}" var="rubros">
							<tr>
							
								<td>${rubros.customerId}</td>
								<td>${rubros.userId}</td>
								<td>${rubros.lastName}</td>


								<td><a class="btn btn-primary"
									href="${pageContext.request.contextPath}/administradorGR.do?op=obtener&id=${rubros.customerId}"><span
										class="glyphicon glyphicon-edit"></span> Obtener información</a> <a
									class="btn btn-danger"
									href="javascript:eliminar('${rubros.customerId}')"><span
										class="glyphicon glyphicontrash"></span> Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#tabla').DataTable();
		});
		<c:if test="${not empty exito}">
		alertify.success('${exito}');
		<c:set var="exito" value="" scope="session" />
		</c:if>
		<c:if test="${not empty fracaso}">
		alertify.error('${fracaso}');
		<c:set var="fracaso" value="" scope="session" />
		</c:if>
		function eliminar(id) {
			alertify.confirm("¿Realmente decea eliminar este Rubro?", function(
					e) {
				if (e) {
					location.href = "administradorGC.do?op=eliminar&id=" + id;
				}
			});
		}
	</script>
</body>
</html>