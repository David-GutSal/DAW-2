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
			<form action="insertarAsignaturas" method="post">
				<div id="formulario">
					<label for="id">Id Asignatura</label> <input type="text" id="id"
						name="id"> <label for="nombre">Nombre Asignatura</label> <input
						type="text" id="nombre" name="nombre"><br> <label
						for="curso">Curso</label> <input type="number" id="curso"
						name="curso"> <label for="tasa">Tasa</label> <input
						type="number" id="tasa" name="tasa"> Activo: <input
						type="checkbox" id="activo" name="activo" value="1" checked><br>
					<input type="submit" value="Enviar">
				</div>
			</form>

			<c:if test="${resultado == 1}">
				<b>Asignatura insertada correctamente</b>
			</c:if>
		</div>
	</div>
</body>