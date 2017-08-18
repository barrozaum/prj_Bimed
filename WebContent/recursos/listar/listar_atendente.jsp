<jsp:useBean id="mb" class="manager.ManagerAtendente"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(document).ready(function() {
		$('#table').DataTable();
	});
</script>
<div class="col-md-10 col-md-offset-1">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Lista Atendentes</div>
		</div>
		<div class="panel-body">
			<table id="table" class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Sexo</th>
						<th>Crm</th>
						<th>Cep</th>
						<th>Alterar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mb.listar_atendente}" var="linha">
						<tr>
							<th>${linha.nome}</th>
							<th>${linha.email}</th>
							<th>${linha.sexo}</th>
							<th>${linha.matricula}</th>
							<th>${linha.endereco.cep}</th>
							<td align="center"><a href="#" id="editar"
								data-id="${linha.idPessoa}"><img
									src="recursos/imagens/estrutura/lupa.png" height="20px;"
									alt="editar" title="consulta dados do processo"></a></td>
							<td align="center"><a href="#" id="excluir"
								data-id="${linha.idPessoa}"><img
									src="recursos/imagens/estrutura/lixeira.png" height="20px;"
									alt="excluir" title="consulta dados do processo"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>