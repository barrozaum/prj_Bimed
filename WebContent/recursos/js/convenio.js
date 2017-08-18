$(function(){
	$(document).on("click", "#btn_cadastro", function(e){
		
//		carregando variaveis
		var convenio = $("#convenio").val();
		var msg_erro = "";
		
//		validação
		if(convenio.length < 3 || convenio.length > 50){
			msg_erro += "CONVÊNIO INVÁLIDO !!! <BR />";
		}
		
		if(msg_erro !== ""){
			$("#msg_erro").html("<div class='alert alert-danger'>"+msg_erro+"</div>");
			return false;
		}else{
			$("#id_form_cadastro").submit();
		}
	});
	
	$(document).on('click', '#editar', function (e) {
        e.preventDefault();
     
        $(".modal-content").html('');
        $(".modal-content").addClass('loader');
        $("#dialog-example").modal('show');
        $.post('recursos/formulario/alterar/form_convenio.jsp',
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
        $.post('recursos/formulario/excluir/form_convenio.jsp',
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