<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession sesion = (HttpSession) request.getSession();
	String nombreImagen = String.valueOf(sesion.getAttribute("nombre"));
%>

<img alt="" src="Files/<%=nombreImagen%>" >
<h1><%=nombreImagen%></h1>
</body>
</html>