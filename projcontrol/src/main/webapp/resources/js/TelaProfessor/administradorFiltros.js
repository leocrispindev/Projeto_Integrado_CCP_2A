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

function getAvaliacaoDetalhes(idAvalia) {
    $.ajax({
        url: 'entrada?acao=VisualizarAvaliacaoDetalhes',
        data: {avaliacaoId: idAvalia},
        type: 'POST',
        success: function (data) {
        	console.log(data);
        	montargridAvaliacaoDetalhada(data);
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

function montargridAvaliacaoDetalhada(data) {
	$('#avaliacoes-info').children().remove().end();
	
	var header = document.createElement('h5');
	var grupoNome = document.createTextNode("Nome: " + data[0].grupo.nome);
	var grupoNum = document.createTextNode("Grupo n\u02DA: " + data[0].grupo.numero_grupo);
	var turmaSigla = document.createTextNode(" Turma: " + data[0].turma.sigla);
	var dataAvaliacao = document.createTextNode( "Data de avalia\u00e7\u00e3o: " + dateFormat(data[0].dataAvaliacao));
	var ativNum = document.createTextNode("Atividade n\u02DA: " + data[0].atividade.numero);
	var ativDescricao = document.createTextNode("Descri\u00e7\u00e3o: " + data[0].atividade.descricao);
	
	
	header.style.color = "white";
	header.appendChild(grupoNome);
	header.appendChild(document.createElement('br'));
	header.appendChild(grupoNum);
	header.appendChild(document.createElement('br'));
	header.appendChild(turmaSigla);
	header.appendChild(document.createElement('br'));
	header.appendChild(dataAvaliacao);
	header.appendChild(document.createElement('br'));
	header.appendChild(ativNum);
	header.appendChild(document.createElement('br'));
	header.appendChild(ativDescricao);

	$('#avaliacoes-info').append(header);
	for(var i = 0; i < data.length; i++) {
		var pNome = document.createElement('p');
		var nome = document.createTextNode(data[i].turma.alunos.nome);
		let br = document.createElement('br');
		var ra = document.createTextNode(" RA: " + data[i].turma.alunos.ra);
		var nota = document.createTextNode("Nota: " + data[i].nota);
		var comentario = document.createTextNode(" | Coment\u00e1rio(s): " + data[i].comentario);
		
		pNome.style.color = "white";
		pNome.appendChild(nome);
		pNome.appendChild(ra);
		pNome.appendChild(br);
		pNome.appendChild(nota);
		pNome.appendChild(comentario);
		$('#avaliacoes-info').append(pNome);
	}
}

function dateFormat(inputDate) {
	var meses = ['jan', 'fev', 'mar', 'abr', 'mai', 'jun', 'jul', 'ago', 'set', 'out', 'nov', 'dez'];
	
	var data = inputDate.split(" ");
	
	var dia = data[1].substring(0, data[1].length - 1);
	var ano = data[2];
	var mes = meses.indexOf(data[0]) + 1;
	
	if(mes <= 9)
		mes = '0' + mes;
	if(dia <= 9)
		dia = '0' + dia;

	return dia + "/" + mes + "/" + ano;
}


$(function(){
	getPeriodoLetivo();
	getProfessores();
});