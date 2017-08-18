<div class="col-sm-10 col-md-10 col-xs-10 col-sm-offset-1 col-md-offset-1 col-xs-offset-1">

	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Cadastro Atendente</div>
		</div>

		<div class="panel-body">
			<form action="ControleAtendente" method="post" id="form_cadastro">
				<input type="hidden" name="acao" id="acao" value="cadastro" />


				<div class="row">
					<div class="col-sm-8 col-sm-offset-0">
						<div class='form-group'>
							<label for="nome">Nome:</label> <input type="text"
								title="informe o nome  " name="nome" id="nome"
								value="" maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8 col-sm-offset-0">
						<div class='form-group'>
							<label for="email">E-mail:</label> <input type="email"
								title="informe o e-mail " name="email" id="email" value=""
								maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-0">
						<div class='form-group'>
							<label for="sexo">Sexo:</label> <select name="sexo"
								class="form-control" title="selecione o sexo">
								<option value="">SELECIONE O SEXO</option>
								<option value="M">MASCULINO</option>
								<option value="F">FEMININO</option>
							</select>
						</div>
					</div>
					<div class="col-sm-6 col-sm-offset-0">
						<div class='form-group'>
							<label for="matricula">Matrícula:</label> <input type="text"
								title="informe a matricula " name="matricula" id="matricula" value=""
								maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-sm-6 col-sm-offset-0">
						<div class='form-group'>
							<label for="cep">Cep:</label> <input type="text"
								title="informe o cep" name="cep" id="cep" value=""
								maxlength="50" class="form-control"
								onblur="retornaCep(this.id, cep, logradouro, bairro, cidade, uf)" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-sm-offset-0">
						<div class='form-group'>
							<label for="logradouro">Logradouro:</label> <input type="text"
								title="informe o logradouro" name="logradouro" id="logradouro"
								value="" maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-5 col-sm-offset-0">
						<div class='form-group'>
							<label for="bairro">Bairro:</label> <input type="text"
								title="informe o bairro" name="bairro" id="bairro" value=""
								maxlength="50" class="form-control" />
						</div>
					</div>
					<div class="col-sm-5 col-sm-offset-0">
						<div class='form-group'>
							<label for="cidade">Cidade:</label> <input type="text"
								title="informe o cidade" name="cidade" id="cidade" value=""
								maxlength="50" class="form-control" />
						</div>
					</div>
					<div class="col-sm-2 col-sm-offset-0">
						<div class='form-group'>
							<label for="uf">UF:</label> <input type="text"
								title="informe o uf" name="uf" id="uf" value="" maxlength="50"
								class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2 col-sm-offset-0">
						<div class='form-group'>
							<label for="numero_end">Número:</label> <input type="text"
								title="informe o nome" name="numeroEndereco" id="numeroEndereco"
								value="" maxlength="50" class="form-control" />
						</div>
					</div>
					<div class="col-sm-10 col-sm-offset-0">
						<div class='form-group'>
							<label for="complemento">Complemento:</label> <input type="text"
								title="informe o complemento" name="complemento"
								id="complemento" value="" maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<hr />

				<div class="row">
					<div class="col-sm-6 col-sm-offset-0">
						<div class='form-group'>
							<label for="telefone1">Telefone:</label> <input type="text"
								title="informe o telefone" name="telefone1" id="telefone1"
								value="" maxlength="50" class="form-control" />
						</div>
					</div>
					<div class="col-sm-6 col-sm-offset-0">
						<div class='form-group'>
							<label for="telefone2">Telefone:</label> <input type="text"
								title="informe o telefone" name="telefone2" id="telefone2"
								value="" maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<button type="submit" class="btn btn-success" id="btn_cadastro">CADASTRAR</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>
