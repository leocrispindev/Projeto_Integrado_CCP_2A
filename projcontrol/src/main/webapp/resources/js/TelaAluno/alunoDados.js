function getPeriodoLetivo() {
	onLoad = document.getElementById('periodo-letivo').options[0].selected = 'selected';
    $.ajax({
        url: 'entrada?acao=GetPeriodoLetivoByAluno',
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

function filtraGrupos() {

	var periodo = $('#periodo-letivo').val().split("/");
	 $('.dd.grupo').children().remove().end();
	
    $.ajax({
        url: 'entrada?acao=GetGruposByAluno',
        data: {id: $('#aluno-id').text(), anoLetivo: periodo[0], semestreLetivo: periodo[1]},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
	        	var card = 
						 "<div class='card text-dark mb-3 card-margin card-grupo' " + 
							"style='max-width: 50rem;'> " + 
							" <div class='card-header'>Grupo n&ordm " + data[i].numero_grupo + " <br/>Nome: " + data[i].nome + "</div> " +
							"<div class='card-body'> " +
								"<h5 class='card-title'>" + data[i].professor.nome + "</h5> " +
								"<p class='card-id' hidden='true'>" + data[i].id + "</p> " +
							"</div> " +
						"</div> "
		        $('.dd.grupo').append(card);
	        	getIntegrantesDoGrupo();
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

function filtraTurmas() {

	var periodo = $('#periodo-letivo').val().split("/");
	 $('.dd.turma').children().remove().end();
		
    $.ajax({
        url: 'entrada?acao=GetTurmasByAluno',
        data: {id: $('#aluno-id').text(), anoLetivo: periodo[0], semestreLetivo: periodo[1]},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
        		var turmasCard = 
    					"<div class='card text-dark mb-3 card-margin' " +
    						"> " +
    						"<div class='card-header'>" + data[i].sigla + "</div> " +
    						"<div class='card-body'> " +
    							"<h5 class='card-title'>" + data[i].turmaTema.titulo + "</h5> " +
    							"<p class='card-text'>" + data[i].turmaTema.introducao + "</p> " +
    						"</div> " +
    					"</div> ";
        		  $('.dd.turma').append(turmasCard);
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

	for(let i = 0; i < arrayIds.length; i++) {
        var id = arrayIds[i].textContent;
        $.ajax({
            url: 'entrada?acao=PreencherGrupos',
            data: {grupoId: id},
            type: 'POST',
            success: function (data) {
                let cardzao = document.querySelectorAll(".card-grupo");
                let cor;
                for(j = 0; j < data.length; j++) {                
                    j%2 == null ? cor = "style='background:#E5E5E5;'" : cor = "";
                    var aluno = "<p class='card-text'" + cor + "><span style='font-weight:bold;'>" + data[j].ra + "</span>" + " | " + data[j].nome + "  </p>"; 
                    $(cardzao[i]).append(aluno);
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

function filtraAtividades() {

	var periodo = $('#periodo-letivo').val().split("/");
	 $('#table-atividades>tbody>tr').remove();
		
    $.ajax({
        url: 'entrada?acao=GetAtividadesByPeriodo',
        data: {id: $('#aluno-id').text(), anoLetivo: periodo[0], semestreLetivo: periodo[1]},
        type: 'POST',
        success: function (data) {
        	for(let i = 0; i < data.length; i++) {
            	var row = 								
    				"<tr> " +
    					"<th class='numeroAtividade' scope='row'>" + data[i].numero + "</th> " +
    					"<td class='descAtividade'>" + data[i].descricao + "</td> " +
    					"<td class='formatoDeEntrega'>" + data[i].formato + "</td> " +
    					"<td class='dataDePostagem'>" + dateFormat(data[i].dataInicio) + "</td> " +
    					"<td class='dataDeEntrega'>" + dateFormat(data[i].dataFim) + "</td> " +
    					"<td><button data-toggle='modal' data-target='#modalEntrega' id='btnEnviarAtividades' " +
    							"type='button' class='btn btn-sm btn-danger'>Enviar Atividade " +
    					"</button></td> " +
    				"</tr>";
            	$('#table-atividades>tbody').append(row);
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

function dateFormat(inputDate) {
	var meses = ['jan', 'fev', 'mar', 'abr', 'mai', 'jun', 'jul', 'ago', 'set', 'out', 'nov', 'dez'];
	
	var data = inputDate.split(" ");
	
	var mesStr = data[0];
	var dia = data[1].substring(0, data[1].length - 1);
	var ano = data[2];
	var mes = meses.indexOf(data[0]) + 1;
	
	if(mes <= 9)
		mes = '0' + mes;
	if(dia <= 9)
		dia = '0' + dia;

	return dia + "/" + mes + "/" + ano;
}


$(function() {
	getPeriodoLetivo();
	getIntegrantesDoGrupo();
});