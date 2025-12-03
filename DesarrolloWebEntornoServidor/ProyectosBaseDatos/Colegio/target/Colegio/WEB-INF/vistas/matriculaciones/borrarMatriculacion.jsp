<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/Colegio/css/index.css">
	 <link rel="stylesheet" href="/Colegio/css/formularios.css">
	 <link rel="stylesheet" href="/Colegio/css/tablas.css">
</head>
<body>
	<%@include file="/menu.html" %>
	<div class="container">
		<h2>Borrar Asignatura</h2>
		<div class="form">
			<form action="formularioBorrarAsignaturas" method="post">

				<label for="id">Id asignatura</label> 
				<input type="text" id="id" name="id"> 
				<label for="nombre">Nombre asignatura</label> 
				<input type="text" id="nombre" name="nombre"><br> 
				<label for="curso">Curso asignatura</label> 
				<input type="number" id="curso" name="curso">
				<label for="tasa">Tasa asignatura</label> 
				<input type="number" id="tasa" name="tasa">
				Activo: 
				<input type="checkbox" id="activo"name="activo" value="1" checked><br> 
				<input type="submit" value="Enviar">
			</form>
		</div>
	</div>


	<c:if test="${empty lista}">
		<h2>No hay resultados que mostrar con esos filtros</h2>
	</c:if>
	<c:if test="${not empty lista}">
		<table>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>CURSO</th>
				<th>TASA</th>
				<th>BORRAR</th>
			</tr>
			<c:forEach items="${lista}" var="asignatura">
				<tr>
					<td id="id">${asignatura.id}</td>
					<td>${asignatura.nombre}</td>
					<td>${asignatura.curso}</td>
					<td>${asignatura.tasa}</td>
					<td>
						<form action="borrarAsignaturas" method="POST" >
							<input type="hidden" name="id" value="${asignatura.id}">
							<input type ="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>