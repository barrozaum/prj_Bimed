<div
	class="col-sm-10  col-md-10 col-xs-10 col-sm-offset-1 col-md-offset-1 col-xs-offset-1">

	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Cadastro Convenio</div>
		</div>

		<div class="panel-body">
			<form action="ControleConvenio" id="id_form_cadastro" method="post">
				<input type="hidden" name="acao" id="acao" value="cadastro" />
				<div class="row">
					<div class="col-sm-12">
						<div id="msg_erro">${msg}</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<div class='form-group'>
							<label for="convenio">Convênio:</label> <input type="text"
								title="informe o convenio " name="convenio" id="convenio"
								value="" maxlength="50" class="form-control" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<button type="button" class="btn btn-success" id="btn_cadastro">CADASTRAR</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>
