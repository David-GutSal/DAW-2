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
<title>Actualizar Matriculas</title>
</head>
<body>
	<h1>Actualizar Matriculas</h1>
	<%@include file="/menu.html" %>
	<div class="container">
		<h2>Actualizar Matriculas</h2>
		<div class="form">
			<form action="formularioActualizarMatriculaciones" method="post">

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
	
	<c:forEach items="${lista}" var="matriculas">
		<div class="form">
			<form action="actualizarMatriculacion" method="post">
				<input type="text" name="id" value="${matriculas.id}" hidden=true> 
				
				<label>Nombre Alumno</label>
	            <select name="alumnos">
	                <c:forEach items="${desplegableAlumnos}" var="alumno">
	                    <option value="${alumno.id}"
	                        <c:if test="${alumno.id == matriculas.alumno}">selected</c:if>>
	                        ${alumno.descripcion}
	                    </option>
	                </c:forEach>
	            </select>
        		<br>
        		
        		<label>Asignaturas</label>
	            <select name="asignaturas">
	                <c:forEach items="${desplegableAsignaturas}" var="asignatura">
	                    <option value="${asignatura.id}"
	                        <c:if test="${asignatura.id == matriculas.asignatura}">selected</c:if>>
	                        ${asignatura.descripcion}
	                    </option>
	                </c:forEach>
	            </select>
        		
				<label for="tasa">Tasa</label>
				<input type="text" id="tasa" name="tasa" value="${matriculas.tasa}">
				<br>
				
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha" value="${matriculas.fecha}">
				<br>

				<input type="submit" value="Modificar">
			</form>
		</div>
	</c:forEach>
</body>
</html>



