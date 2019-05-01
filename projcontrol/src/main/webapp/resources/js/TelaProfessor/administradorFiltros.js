function getPeriodoLetivo() {

    $.ajax({
        url: 'entrada?acao=FiltroPeriodoLetivo',
        data: {},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
        		var anoCb = document.getElementById('ano-letivo');
        		var addAno = document.createElement('option');
        		addAno.appendChild(document.createTextNode(data[i].anoLetivo));
        		anoCb.appendChild(addAno);
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

function getTurmasByPeriodoLetivo() {
    $.ajax({
        url: 'entrada?acao=FiltroTurmasByPeriodo',
        data: {ano_letivo: $('#ano-letivo').val(), semestreLetivo: $('#semestre-letivo').val() },
        type: 'POST',
        success: function (data) {
        	$('#turma').children().remove().end();
        	$('#turma').prepend('<option disabled selected>Turma</option>');
        	
        	for(i = 0; i < data.length; i++) {
	        	$('#turma').append($('<option>', {
	        	    value: data[i].codigoIdentificador,
	        	    text: data[i].sigla
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

function getGruposByTurmas() {

    $.ajax({
        url: 'entrada?acao=FiltroGruposByTurmas',
        data: {codigoIdentificador: $('#turma').val()},
        type: 'POST',
        success: function (data) {
        	$('#grupo').children().remove().end();
        	$('#grupo').prepend('<option disabled selected>Grupo</option>');
        	
        	for(i = 0; i < data.length; i++) {
        		$('#grupo').append($('<option>', {
        			value: data[i].id,
        			text: data[i].nome
        		}))
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

function getProfessores() {

    $.ajax({
        url: 'entrada?acao=FiltroProfessores',
        data: {},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
        		$('#professor').append($('<option>', {
        			value: data[i].id,
        			text: data[i].nome
        		}))
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
	var ano = document.getElementById('ano-letivo');
	var semestre = document.getElementById('semestre-letivo');
	if( ano.selectedIndex != 0 && semestre.selectedIndex != 0) {
		getTurmasByPeriodoLetivo();
	}
}


$(function(){
	getPeriodoLetivo();
	getProfessores();
});