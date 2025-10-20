<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hola, la persona se llama ${persona.nombre} y tiene
		${persona.edad} años.</p>
	<p>El equipo en la posición 1 del array de equipos es:
		${listaEquipos[1]}</p>
	<p>La persona en la posición 0 del array se llama
		${listaPersonas[0].nombre }</p>
	<p>La suma de edades de la persona en la posición cero y la persona
		en la posición 1 de la lista es: ${listaPersonas[0].edad} +
		${listaPersonas[1].edad} = ${listaPersonas[0].edad + listaPersonas[1].edad}
	</p>
	<p>La persona en la posición cero de la lista es mayor que la
		persona en la posición 1: ${listaPersonas[0].edad > listaPersonas[1].edad}
	</p>
	<p>La persona en la posición cero de la lista es mayor que la
		persona en la posición 1 y mayor que la persona en la posición 2:
		${listaPersonas[0].edad > listaPersonas[1].edad &&
listaPersonas[0].edad > listaPersonas[2].edad}
	</p>
</body>

</html>