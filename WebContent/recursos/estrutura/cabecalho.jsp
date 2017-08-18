<div class="page-header">
	<div
		class="mainbox col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0">
		<!-- div que posiciona o formulário na tela -->
		<div class="row">
			<div class="col-lg-2 col-lg-offset-0 text-center">
				<a href="inicial.jsp"> <img
					src="recursos/imagens/estrutura/logo.jpg" height="76px"
					alt="logo cliente" title="logo da prefeitura">
				</a>
			</div>
			<div class="col-lg-9 col-lg-offset-0 ">
				<nav class="navbar navbar-default nav-justified" role="navigation">
					<!-- Brand and toggle get grouped for better mobile display -->

					<div class="navbar-header ">
						<a class="navbar-brand" href="inicial.jsp">Bimed-Saude</a>
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-ex1-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse navbar-ex1-collapse ">
						<ul class="nav navbar-nav ">

							<li class="root"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">CADASTRO <b class="caret"></b></a>
								<ul class="dropdown-menu">
								<% if(10 == 10){ %>
									<li><a href="cadastro_medico.jsp">MEDICO</a></li>
								<% } %>
									
									<li><a href="cadastro_paciente.jsp">PACIENTE</a></li>
									<li><a href="cadastro_atendente.jsp">SECRETÁRIA</a></li>

								</ul></li>
							<li class="dropdown"><a href="especialidade.jsp">ESPECIALIDADE</a></li>
							<li class="dropdown"><a href="convenio.jsp">CONVÊNIO</a></li>

							<li class="dropdown"><a href="LoginController">SAIR</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
	</div>
</div>
<hr />
