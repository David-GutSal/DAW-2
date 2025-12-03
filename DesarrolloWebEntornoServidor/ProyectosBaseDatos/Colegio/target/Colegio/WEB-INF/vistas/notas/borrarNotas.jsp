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
		<h2>Borrar Nota</h2>
		<div class="form">
			<form action="formularioBorrarNotas" method="post">

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


	<c:if test="${empty lista}">
		<h2>No hay resultados que mostrar con esos filtros</h2>
	</c:if>
	<c:if test="${not empty lista}">
		<table>
			<tr>
				<th>ID ALUMNO</th>
				<th>NOMBRE ALUMNO</th>
				<th>ASIGNATURA</th>
				<th>NOTA</th>
				<th>FECHA</th>
				<th>ACCIÓN</th>
			</tr>
			<c:forEach items="${lista}" var="notas">
				<tr>
					<td>${notas.alumno}</td>
					<td>
					    <c:forEach items="${desplegableAlumnos}" var="al">
					        <c:if test="${al.id == notas.alumno}">
					            ${al.descripcion}
					        </c:if>
					    </c:forEach>
					</td>
					<td>
					    <c:forEach items="${desplegableAsignaturas}" var="as">
					        <c:if test="${as.id == notas.asignatura}">
					            ${as.descripcion}
					        </c:if>
					    </c:forEach>
					</td>
					<td>${notas.nota}</td>
					<td>${notas.fecha}</td>
					<td>
						<form action="borrarNotas" method="POST">
						    <input type="hidden" name="id" value="${notas.alumno}">
						    <input type="hidden" name="asignaturas" value="${notas.asignatura}">
						    <input type="hidden" name="nota" value="${notas.nota}">
						    <input type="hidden" name="fecha" value="${notas.fecha}">
						    <input type="submit" value="Borrar" onclick="return confirm('¿Seguro que quieres borrar esta nota?');">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>