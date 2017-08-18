<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Sistema - Bimed</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="recursos/css/login.css">
</head>
<body>

	<div class="card card-container">
		<p align="center">
			<strong>SISTEMA BIMED</strong>
		</p>
		<img id="profile-img" class="profile-img-card"
			src="recursos/imagens/estrutura/logo.jpg" />
		<p id="profile-name" class="profile-name-card"></p>
		<form id="loginform" name="f1" class="form-signin" role="form"
			method="post" action="LoginController">
			<span id="reauth-email" class="reauth-email"></span> <input
				type="text" id="txtlogin" name="txtlogin" class="form-control"
				placeholder="Login" required autofocus /> <input type="password"
				id="txtsenha" name="txtsenha" class="form-control"
				placeholder="Senha" required /> <input type="hidden" name="acao"
				value="logar" />
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Logar</button>
			${msg}
		</form>
		<!-- /form -->
	</div>
	<!-- /card-container -->
</body>
</html>