$(function(){
	$(document).on("click", "#btn_cadastro", function(e){
		
//		carregando variaveis
		var especialidade = $("#especialidade").val();
		var valor = $("#valor_consulta").val();
		var msg_erro = "";
		
//		validação
		if(especialidade.length < 3 || especialidade.length > 50){
			msg_erro += "ESPECIALIDADE INVÁLIDA !!! <BR />";
		}
		if(valor.length < 3){
			msg_erro += "VALOR CONSULTA INVÁLIDO";
		}
		
		if(msg_erro !== ""){
			$("#msg_erro").html("<div class='alert alert-danger'>"+msg_erro+"</div>");
			return false;
		}else{
			$("#form_cadastro").submit();
		}
	});
	
	$(document).on('click', '#editar', function (e) {
        e.preventDefault();
     
        $(".modal-content").html('');
        $(".modal-content").addClass('loader');
        $("#dialog-example").modal('show');
        $.post('recursos/formulario/alterar/form_medico.jsp',
                {cmd: "editar",
                    codigo: $(this).attr('data-id')
                },
        function (html) {
            $(".modal-content").removeClass('loader');
            $(".modal-content").html(html);
        }
        );
    });
	
	$(document).on('click', '#excluir', function (e) {
        e.preventDefault();
     
        $(".modal-content").html('');
        $(".modal-content").addClass('loader');
        $("#dialog-example").modal('show');
        $.post('recursos/formulario/excluir/form_medico.jsp',
                {cmd: "editar",
                    codigo: $(this).attr('data-id')
                },
        function (html) {
            $(".modal-content").removeClass('loader');
            $(".modal-content").html(html);
        }
        );
    });
});