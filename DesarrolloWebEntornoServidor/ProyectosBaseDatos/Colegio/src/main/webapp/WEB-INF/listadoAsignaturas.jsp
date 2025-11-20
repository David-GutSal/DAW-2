<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${listaAsignaturas}" var="asignatura">
		<li> ID: ${asignatura.id}. Nombre: ${asignatura.nombre}. Curso: ${asignatura.curso}. Tasa: ${asignatura.tasa} </li>
	</c:forEach>
</body>
</html>