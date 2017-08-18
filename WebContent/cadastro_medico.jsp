<%@page import="entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Usuario username = (Usuario) session.getAttribute("Usuario");
	if (username == null) {
		request.setAttribute("msg", " EFETUE LOGIN");
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
<link rel="stylesheet" href="recursos/css/bootstrap.css">
<script type="text/javascript" src="recursos/js/jquery.min.js"></script>
<script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>
<script type="text/javascript" src="recursos/js/medico.js"></script>
<link rel="stylesheet" href="recursos/css/jquery.dataTables.min.css">
<script src="recursos/js/jquery.dataTables.min.js"></script>
<script src="recursos/js/consultar_cep.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#cabecalho').load('recursos/estrutura/cabecalho.jsp');
				$('#modal').load('recursos/estrutura/modal.html');
				$('#formulario').load(
						'recursos/formulario/cadastro/form_medico.jsp');
				$('#listar').load(
						'recursos/listar/listar_medico.jsp');
			});
</script>

</head>
<body>

	<div class="container-fluid">
		<div id="cabecalho">
			<!-- Não apagar, pois é onde encontra-se o menu do site -->
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div id="msg_erro">${msg}</div>
			</div>
		</div>
		<div class="container bg-4 text center">

			<div id="formulario"></div>
		</div>
		<div class="container bg-4 text center">

			<div id="listar"></div>
		</div>
		<div id='modal'></div>
	</div>
</body>
</html>