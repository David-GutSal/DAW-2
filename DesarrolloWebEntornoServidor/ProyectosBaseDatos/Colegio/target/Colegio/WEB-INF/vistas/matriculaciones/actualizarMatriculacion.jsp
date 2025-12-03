<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Colegio/css/index.css">
<link rel="stylesheet" href="/Colegio/css/formularios.css">
<title>Actualizar Asignaturas</title>
</head>
<body>
	<h1>Actualizar Asignaturas</h1>
	<%@include file="/menu.html" %>
	<div class="container">
		<h2>Actualizar Asignaturas</h2>
		<div class="form">
			<form action="formularioActualizarAsignaturas" method="post">

				<label for="id">Id Asignatura</label> 
				<input type="text" id="id" name="id"> 
				
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre"><br> 
				
				<label for="curso">Curso Asignatura</label> 
				<input type="number" id="curso" name="curso">
				<label for="tasa">Tasa Asignatura</label> 
				<input type="number" id="tasa" name="tasa">
				Activo: 
				<input type="checkbox" id="activo"name="activo" value="1" checked><br> 
				<input type="submit" value="Enviar">
			</form>
		</div>
	</div>
	
	<c:forEach items="${lista}" var="asignatura">
		<div class="form">
			<form action="actualizarAsignaturas" method="post">
			    <label for="id"> Id Asignatura</label>
				<input type="text" id="id" name="id" value="${asignatura.id}" hidden>
				<label for="nombre">Nombre Asignatura</label>
				<input type="text" id="nombre" name="nombre" value="${asignatura.nombre}"><br>
				<label for="curso">Curso Asignatura</label>
				<input type="number" id="curso" name="curso" value="${asignatura.curso}"><br>
				<label for="tasa">Tasa Asignatura</label>
				<input type="number" id="tasa" name="tasa" value="${asignatura.tasa}"><br>
				
				Activo:
				<c:if test="${asignatura.activo == 1}">
					<input type="checkbox" id="activo" name="activo" value="1" checked><br>
				</c:if>
				<c:if test="${asignatura.activo == 0}">
					<input type="checkbox" id="activo" name="activo" value="0" checked><br>
				</c:if>
				

			<input type="submit" value="Modificar">
			</form>
		</div>
	</c:forEach>
</body>
</html>



