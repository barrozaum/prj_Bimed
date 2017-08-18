<jsp:useBean id="mb" class="manager.ManagerAtendente"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Integer cod = new Integer(request.getParameter("codigo"));
	mb.findByCode(cod);
%>
<div class="modal-header alert-danger">
	<button type="button" class="close" data-dismiss="modal">&times;
	</button>
	<h4 class="modal-title">Excluir Atente</h4>
</div>
<div class="modal-body ">
	<form action="ControleAtente" method="post"
		id="form_excluir">
		<div class="panel-body">

			<input type="hidden" name="acao" id="acao" value="excluir" />
			<input type="hidden" name="id_pessoa" id="id_pessoa" value="${mb.atendente.idPessoa}" />
			

			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="nome">Nome:</label> <input type="text"
							title="informe o nome " name="nome" id="nome"
							value="${mb.atendente.nome}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="email">Email:</label> <input type="text"
							title="informe o email " name="email" id="email"
							value="${mb.atendente.email}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class='form-group'>
						<label for="matricula">Matricula:</label> <input type="text"
							title="informe a matricula " name="matricula" id="matricula"
							value="${mb.atendente.matricula}" maxlength="50" class="form-control" />
					</div>
				</div>
			</div>
			
			
			
		<div class="modal-footer">
				<button type="submit" class="btn btn-danger" >EXCLUIR</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">FECHAR</button>
			</div>
	</form>
</div>

