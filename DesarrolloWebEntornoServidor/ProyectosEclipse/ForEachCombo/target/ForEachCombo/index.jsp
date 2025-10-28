<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista personas</title>
</head>
<body>
    <h1>Lista personas:</h1>
    <ul>
        <c:forEach items="${listaPersonas}" var="p">
            <li>${p.nombre} - ${p.saldoCuenta}</li>
        </c:forEach>
    </ul>
</body>
</html>
