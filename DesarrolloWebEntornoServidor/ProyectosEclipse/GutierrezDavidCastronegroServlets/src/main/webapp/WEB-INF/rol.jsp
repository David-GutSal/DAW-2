<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Asignar rol a jugador</h1>
	<p>Elige jugador para asignar rol:</p>

	<form action="Controller" method="POST">
		<select name="jugadorId">
			<c:forEach items="${opcionesDesplegable}" var="p">
				<option value="${p.id}">${p.name}</option>
			</c:forEach>
		</select> <input type="submit" value="Asignar rol">
	</form>
	<c:if test="${not empty rol}">
		<h3>Jugador seleccionado: ${nombreJugador}</h3>
		<h4>Rol asignado: ${rol}</h4>
		<c:choose>
			<c:when test="${rol == 'lobo'}">
				<p>¡Cuidado! Este personaje es un lobo</p>
			</c:when>
			<c:when test="${rol == 'vidente'}">
				<p>Puede revelar el rol de otra persona</p>
			</c:when>
			<c:when test="${rol == 'campesino'}">
				<p>Este personaje no hace nada especial</p>
			</c:when>
			<c:when test="${rol == 'cazador'}">
				<p>Este personaje puede vengarse si muere</p>
			</c:when>
			<c:otherwise>
				<p>Rol desconocido</p>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>