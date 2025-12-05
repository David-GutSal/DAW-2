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
		<h2>Borrar Matricula</h2>
		<div class="form">
			<form action="formularioBorrarMatriculas" method="post">

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
				<label for="date">Fecha</label>
				<input type="date" id="date" name="date">
				 
				<input type="submit" value="Enviar">
			</form>
		</div>
	</div>


	<c:if test="${empty lista}">
		<h2>No hay resultados que mostrar con esos filtros</h2>
	</c:if>
	<c:if test="${not empty lista}">
		<table>
			<c:forEach items="${lista}" var="matriculas">
				<ul>
					<li>Alumno: ${matriculas.alumno}</li>
					<li>Asignatura: ${matriculas.asignatura}</li>
					<li>Fecha: ${matriculas.fecha}</li>
					<li>Tasa: ${matriculas.tasa}</li>
					<li>
						<form action="borrarMatriculacion" method="POST" >
							<input type="hidden" name="id" value="${matriculas.id}">
							<input type ="submit" value="Borrar">
						</form>
					</li>
				</ul>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>