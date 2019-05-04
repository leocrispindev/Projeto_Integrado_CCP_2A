function getPeriodoLetivo() {
	onLoad = document.getElementById('periodo-letivo').options[0].selected = 'selected';
    $.ajax({
        url: 'entrada?acao=GetPeriodoLetivo',
        data: {id: $('#aluno-id').text()},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
	        	$('#periodo-letivo').append($('<option>', {
	        	    value: data[i].anoLetivo + "/" + data[i].semestreLetivo,
	        	    text: data[i].anoLetivo + "/" + data[i].semestreLetivo
	        	}));
        	} 
        },
        error: function(data) {
            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })
            
        }
    });
}

function filtraGrupo() {

	var periodo = $('#periodo-letivo').val().split("/");
	
    $.ajax({
        url: 'entrada?acao=GetGruposByAluno',
        data: {id: $('#aluno-id').text(), anoLetivo: periodo[0], semestreLetivo: periodo[1]},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
	        	var card = "<div class='card text-dark bg-light mb-3 card-margin card-grupo' style='max-width: 18rem;'>" +
		        			"<div class='card-header'>Grupo no." + data[i].numero_grupo + " </div>" +
		        			"<div class='card-body'>" +
			        			"<h5 class='card-title'>" + data[i].professor.nome + " </h5>" +
//			        			"<p class='card-text'>[Aluno] <small style='font-weight:bold;'>[Nota]</small></p>" +
		        			"</div>" +
	        			"</div>"
		        $('#sass').append(card);
        	}
        },
        error: function(data) {
            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })
            
        }
    });
}

function getIntegrantesDoGrupo(){
	
	var arrayIds = $('.card-id');
	var grupos = $('.card.text-dark.bg-light.mb-3.card-margin.card-grupo');
	for(i = 0; i < arrayIds.length; i++) {
		var id = arrayIds[i].textContent;
		var card = grupos[i];
		
    $.ajax({
        url: 'entrada?acao=PreencherGrupos',
        data: {grupoId: id},
        type: 'POST',
        success: function (data) {
        	for(j = 0; j < data.length; j++) {
        		var aluno = "<p class='card-text'>RA: " + data[j].ra + " | " + data[j].nome + "  </p>"; 
        		 $(card).append(aluno);
        	}
        },
        error: function(data) {
            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })
            
        }
    });
}
}

$(function() {
	getPeriodoLetivo();
	getIntegrantesDoGrupo();
});