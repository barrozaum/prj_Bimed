<%@page import="entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Usuario username = (Usuario) session.getAttribute("Usuario");
	if (username == null) {
		request.setAttribute("msg", " ACESSO NEGADO ");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>


<!DOCTYPE html>
<html lang="pt">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Sistema - Bimed</title>
<link rel="stylesheet" href="recursos/css/bootstrap.css">
<link rel="stylesheet" href="recursos/css/menu.css">
<script type="text/javascript" src="recursos/js/jquery.min.js"></script>
<script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>
<script type="text/javascript" src="recursos/js/especialidade.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#cabecalho').load('recursos/estrutura/cabecalho.jsp');
	});
</script>

</head>
<body>

	<div class="container-fluid">
		<div id="cabecalho">
			<!-- Não apagar, pois é onde encontra-se o menu do site -->
		</div>


	</div>
</body>
</html>