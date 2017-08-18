<jsp:useBean id="mb" class="manager.ManagerConvenio"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(document).ready(function() {
		$('#table').DataTable();
	});
</script>
<div class="col-md-10 col-md-offset-1">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Lista Convenio</div>
		</div>
		<div class="panel-body">
			<table id="table" class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Convenio</th>
						<th>Alterar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mb.listar_convenio}" var="linha">
						<tr>
							<th>${linha.descricaoConvenio}</th>
							<td align="center"><a href="#" id="editar"
								data-id="${linha.idConvenio}"><img
									src="recursos/imagens/estrutura/lupa.png" height="20px;"
									alt="editar" title="consulta dados do processo"></a></td>
							<td align="center"><a href="#" id="excluir"
								data-id="${linha.idConvenio}"><img
									src="recursos/imagens/estrutura/lixeira.png" height="20px;"
									alt="excluir" title="consulta dados do processo"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>