<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>

<script type="text/javascript"></script>

	$(document).ready(function(){
	
		$.post('ControllerMostrarInformacion',{
		
		},function(response){
		
			let datos = JSON.parse(response);
			
			console.log(datos);
		});
	});
	
</body>
</html>