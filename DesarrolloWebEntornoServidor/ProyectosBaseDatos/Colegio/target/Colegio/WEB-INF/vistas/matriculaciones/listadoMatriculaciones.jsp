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
			<form action="listadoMatriculaciones"
				method="post">
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="asignatura" name="asignatura"><br> 
				
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="alumno" name="alumno"><br> 
				
				<label for="date">Fecha (desde)</label> 
				<input type="date" id="date" name="date">
				
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
				<th>Nombre Asignatura</th>
				<th>Nombre Alumno</th>
				<th>Fecha</th>
				<th>Activo</th>
				<th>Tasa</th>
			</tr>
			<c:forEach items="${lista}" var="matricula">
				<tr>
					<td>${matricula.asignatur}</td>
					<td>${matricula.alumno}</td>
					<td>${matricula.fecha}</td>
					<td>${matricula.activo}</td>
					<td>${matricula.tasa}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>

