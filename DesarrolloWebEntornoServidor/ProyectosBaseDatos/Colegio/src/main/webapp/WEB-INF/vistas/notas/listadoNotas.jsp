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
	<h1>Listado Notas</h1>
	<%@include file="/menu.html" %>

	<div class="container">
		<div class="form">
			<form action="listadoNotas"
				method="post">
				<label for="id">Id Alumno</label>
				<input type="text" id="id" name="id">
				
				<label for="alumnos">Nombre Alumno</label> 
				 <select name="alumnos" id="alumnos">
            		<c:forEach items="${desplegableAlumno}" var="alumno">
                		<option value="${alumno.id}">${alumno.id_alumno}</option>
            		</c:forEach>
        		</select>
        		
        		<label for="asignaturas">Asignaturas</label> 
				 <select name="asignaturas" id="asignaturas">
            		<c:forEach items="${desplegableAsignatura}" var="asignatura">
                		<option value="${asignatura.id}">${asignatura.id_asignatura}</option>
            		</c:forEach>
        		</select>
        		
				<label for="nota">Nota</label> 
				<input type="number" id="nota" name="nota">
				
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha">
				
				Alumno Activo: 
				<input type="checkbox" id="activo" name="activo" value="1" checked><br>
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
				<th>NOMBRE ALUMNO</th>
				<th>ASIGNATURA</th>
				<th>NOTA</th>
				<th>FECHA</th>
			</tr>
			<c:forEach items="${lista}" var="notas">
				<tr>
					<td>${notas.id}</td>
					<td>${notas.id_alumno}</td>
					<td>${notas.id_asignatura}</td>
					<td>${notas.nota}</td>
					<td>${notas.fecha}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>

