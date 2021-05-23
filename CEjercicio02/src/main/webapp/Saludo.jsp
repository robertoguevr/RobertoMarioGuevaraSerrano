<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js&quot; integrity="
	sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>
	<script type="text/javascript">
			$(document).ready(function () {
				$.post('ControllerMostrarInformacion', {
				}, function (response) {
					let datos = JSON.parse(response);
					console.log(datos);
					var tabla = document.getElementById('tablaDatos');
					for (let item of datos) {
						tabla.innerHTML += `
					<tr>
						<td>${item.idUsuario}</td>
						<td>${item.Usuario}</td>
						<td>${item.Pass}</td>
						<td><a href="ControllerMostrarInformacion?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger">ELIMINAR</a>
						<a href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.Pass}" class="btn btn-warning">ACTUALIZAR</a>
						</td> 
					</tr>
					`
						console.log(item.Pass);
					}
				});
			});
		</script>
		<%
		HttpSession sesion = (HttpSession) request.getSession(); 
		String usuSession = String.valueOf(sesion.getAttribute("usuario"));
		System.out.println(usuSession + "Nombre usuario");
		
		if(usuSession.equals(null)|| usuSession.equals("null")){
			
			response.sendRedirect("index.jsp");
		}
		%>
		
		
		
		
	<h1>WELCOME</h1>


	<br>
	<table class="table table-dark table-striped" id="tablaDatos">
		<thead>
			<th>IdUsuario</th>
			<th>USUARIO</th>
			<th>PASSWORD</th>
			<th>ACCIONES</th>
		</thead>
	</table>
</body>
</html>