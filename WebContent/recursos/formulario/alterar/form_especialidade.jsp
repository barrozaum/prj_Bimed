<jsp:useBean id="mb" class="manager.ManagerEspecialidade"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Integer cod = new Integer(request.getParameter("codigo"));
	mb.findByCode(cod);
%>
<div class="modal-header alert-info">
	<button type="button" class="close" data-dismiss="modal">&times;
	</button>
	<h4 class="modal-title">Alterar Especialidade</h4>
</div>
<div class="modal-body ">
	<form action="ControleEspecialidade" method="post"
		id="form_alterar">
			<div class="panel-body">

				<input type="hidden" name="acao" id="acao" value="alterar" />
				<input type="hidden" name="id_especialidade" id="id_especialidade" value="${mb.especialidade.idEspecialidade}" />
				<div class="row">
					<div class="col-sm-12">
						<div id="msg_erro">${msg}</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<div class='form-group'>
							<label for="especialidade">Especialidade:</label> <input
								type="text" title="informe a especialidade "
								name="especialidade" id="especialidade"
								value="${mb.especialidade.descricaoEspecialidade}"
								maxlength="50" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<div class='form-group'>
							<label for="valor_consulta">Valor Consulta:</label> <input
								type="text" title="informe o valor da consulta "
								name="valor_consulta" id="valor_consulta"
								value="${mb.especialidade.valorConsulta}" maxlength="50"
								class="form-control" />
						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-info" >ALTERAR</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">FECHAR</button>
			</div>
	</form>
</div>

