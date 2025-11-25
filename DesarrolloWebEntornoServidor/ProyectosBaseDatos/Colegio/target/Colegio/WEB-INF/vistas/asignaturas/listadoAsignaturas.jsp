<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/Colegio/css/index.css">
<link rel="stylesheet" type="text/css"
	href="/Colegio/css/formularios.css">
<link rel="stylesheet" type="text/css" href="/Colegio/css/tablas.css">
<meta charset="ISO-8859-1">
<title>Listado Notas</title>
</head>
<body>

	<h1>Listado asignaturas</h1>
	<%@include file="/menu.html" %>

	<div class="container">
		<div class="form">
			<form action="listadoAsignaturas"
				method="post">
				<label for="id">Id Asignatura</label>
				<input type="text" id="id" name="id"> 
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre"><br> 
				<label for="curso">Curso</label> 
				<input type="number" id="curso" name="curso">
				<label for="tasa">Tasa</label> 
				<input type="number" id="tasa" name="tasa">
				Activo: 
				<input type="checkbox" id="activo" name="activo" value="1"><br>
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
			</tr>
			<c:forEach items="${lista}" var="asignatura">
				<tr>
					<td>${asignatura.id}</td>
					<td>${asignatura.nombre}</td>
					<td>${asignatura.curso}</td>
					<td>${asignatura.tasa}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>

