<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/Colegio/css/index.css">
<link rel="stylesheet" href="/Colegio/css/formularios.css">
</head>
<body>
	<header>
		<h2>Inserción de nueva asignatura</h2>
	</header>
	<%@include file="/menu.html"%>

	<div class="container">
		<div class="form">
			<form action="insertarNotas" method="post">
				<div id="formulario">
				
				<label for="alumnos">Nombre Alumno</label> 
				 <select name="alumnos" id="alumnos">
            		<c:forEach items="${desplegableAlumnos}" var="alumno">
                		<option value="${alumno.id}">${alumno.descripcion}</option>
            		</c:forEach>
        		</select>
        		<br>
        		<label for="asignaturas">Asignaturas</label> 
				 <select name="asignaturas" id="asignaturas">
            		<c:forEach items="${desplegableAsignaturas}" var="asignatura">
                		<option value="${asignatura.id}">${asignatura.descripcion}</option>
            		</c:forEach>
        		</select>
        		<br>
				<label for="nota">Nota</label>
				<input type="number" id="nota" name="nota">
				<br>
				<label for="fecha">Fecha (dejar vacío para fecha actual)</label> 
				<input type="date" id="fecha" name="fecha">
				<br>
				<input type="submit" value="Enviar">
				</div>
			</form>

			<c:if test="${resultado == 1}">
				<b>Asignatura insertada correctamente</b>
			</c:if>
		</div>
	</div>
</body>