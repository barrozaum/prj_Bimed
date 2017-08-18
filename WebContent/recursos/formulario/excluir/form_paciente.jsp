<jsp:useBean id="mb" class="manager.ManagerPaciente"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Integer cod = new Integer(request.getParameter("codigo"));
	mb.findByCode(cod);
%>
<div class="modal-header alert-danger">
	<button type="button" class="close" data-dismiss="modal">&times;
	</button>
	<h4 class="modal-title">Excluir Paciente</h4>
</div>
<div class="modal-body ">
	<form action="ControlePaciente" method="post"
		id="form_excluir">
		<div class="panel-body">

			<input type="hidden" name="acao" id="acao" value="excluir" />
			<input type="hidden" name="id_pessoa" id="id_pessoa" value="${mb.paciente.idPessoa}" />
			

			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="nome">Nome:</label> <input type="text"
							title="informe o nome " name="nome" id="nome"
							value="${mb.paciente.nome}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="email">Email:</label> <input type="text"
							title="informe o email " name="email" id="email"
							value="${mb.paciente.email}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>
			
			
			<c:forEach items="${mb.paciente.convenios}" var="linha">
				<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="especialidade">Convênio:</label> <input type="text"
							title="informe o convenio " name="convenio" id="convenio"
							value="${linha.descricaoConvenio}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>				
			</c:forEach>
		</div>

		<div class="modal-footer">
				<button type="submit" class="btn btn-danger" >EXCLUIR</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">FECHAR</button>
			</div>
	</form>
</div>

