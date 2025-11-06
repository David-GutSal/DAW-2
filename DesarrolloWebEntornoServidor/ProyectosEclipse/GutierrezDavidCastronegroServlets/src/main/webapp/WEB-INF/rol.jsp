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
	<p>Elige jugador para asignar rol</p>
	<form action="POST">
		<select>
			<c:forEach items="${opcionesDesplegable}" var="p">
				<option value="${p.id}">${p.name}</option>
			</c:forEach>
		</select>
		<input type="button" value="Asignar rol"></input>
	</form>

	<h3>Jugador: </h3>
	<h4>Rol asignado: </h4>
	<c:if test="${not empty rol}">
		<c:choose>
			<c:when test="${rol == lobo}">
				<p>¡Cuidado! Este personaje es un lobo</p>
			</c:when>
			<c:when test="${rol == vidente}">
				<p>El vidente</p>
			</c:when>
			<c:when test="${rol == campesino}">
				<p>El campesino</p>
			</c:when>
			<c:when test="${rol == cazador}">
				<p>Este personaje puede vengarse si muere</p>
			</c:when>
		</c:choose>
	</c:if>
</body>
</html>