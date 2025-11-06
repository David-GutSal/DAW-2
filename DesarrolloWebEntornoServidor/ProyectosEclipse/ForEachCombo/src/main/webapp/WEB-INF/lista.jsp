<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
	<h1>Seleccione un jugador</h1>
	<select>
		<c:forEach items="${opcionesDesplegable}">
			<option value="${p.id}">${p.name}</option>
		</c:forEach>
	</select>
	<button>Asignar rol</button>
	<c:if test="${not empty rol}">
		
	</c:if>
</body>
</html>