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
<title>Actualizar Notas</title>
</head>
<body>
	<h1>Actualizar Notas</h1>
	<%@include file="/menu.html" %>
	<div class="container">
		<h2>Actualizar Notas</h2>
		<div class="form">
			<form action="formularioActualizarNotas" method="post">

			<label for="alumnos">Nombre Alumno</label> 
				 <select name="alumnos" id="alumnos">
				 	<option value=""></option>
            		<c:forEach items="${desplegableAlumnos}" var="alumno">
                		<option value="${alumno.id}">${alumno.descripcion}</option>
            		</c:forEach>
        		</select>
        		<br>
        		<label for="asignaturas">Asignaturas</label> 
				 <select name="asignaturas" id="asignaturas">
				 	<option value=""></option>
            		<c:forEach items="${desplegableAsignaturas}" var="asignatura">
                		<option value="${asignatura.id}">${asignatura.descripcion}</option>
            		</c:forEach>
        		</select>
        		<br>
				<label for="fecha">Fecha (dejar vacío para fecha actual)</label> 
				<input type="date" id="fecha" name="fecha">
				<br>
				<input type="submit" value="Enviar">
			</form>
		</div>
	</div>
	
	<c:forEach items="${lista}" var="notas">
		<div class="form">
			<form action="actualizarNotas" method="post">
				<input type="text" id="id" name="id" value="${notas.id}" hidden=true> 
				
				<label for="alumnos">Nombre Alumno</label> 
				<select name="alumnos" id="alumnos">
            		<c:forEach items="${desplegableAlumnos}" var="alumno">
                		<option value="${alumno.id}" 
						    <c:if test="${alumno.id == notas.id_alumno}">selected</c:if>>
						    ${alumno.descripcion}
						</option>
            		</c:forEach>
        		</select>
        		<br>
        		
        		<label for="asignaturas">Asignaturas</label> 
				 <select name="asignaturas" id="asignaturas">
            		<c:forEach items="${desplegableAsignaturas}" var="asignatura">
                		<option value="${asignatura.id}" 
					    <c:if test="${asignatura.id == notas.id_asignatura}">selected</c:if>>
					    ${asignatura.descripcion}
					</option>
            		</c:forEach>
        		</select>
        		
				<label for="nota">Nota</label>
				<input type="number" id="nota" name="nota" value="${notas.nota}">
				<br>
				
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha" value="${notas.fecha}">
				<br>
				
				<input type="submit" value="Modificar">
			</form>
		</div>
	</c:forEach>
</body>
</html>



