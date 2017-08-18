<jsp:useBean id="mb" class="manager.ManagerMedico"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Integer cod = new Integer(request.getParameter("codigo"));
	mb.findByCode(cod);
%>
<div class="modal-header alert-info">
	<button type="button" class="close" data-dismiss="modal">&times;
	</button>
	<h4 class="modal-title">Alterar Convênio</h4>
</div>
<div class="modal-body ">
	<form action="ControleConvenio" method="post"
		id="form_alterar">
		<div class="panel-body">

			<input type="hidden" name="acao" id="acao" value="alterar" /> <input
				type="hidden" name="id_convenio" id="id_convenio"
				value="${mb.medico.idPessoa}" />
			

			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="convenio">Nome:</label> <input type="text"
							title="informe o convenio " name="convenio" id="convenio"
							value="${mb.medico.nome}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>
		</div>

		<div class="modal-footer">
			<button type="submit" class="btn btn-info">ALTERAR</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">FECHAR</button>
		</div>
	</form>
</div>

