function getPeriodoProfessor() {
	onLoad = document.getElementById('periodo-letivo-professor').options[0].selected = 'selected';
    $.ajax({
        url: 'entrada?acao=GetPeriodoLetivo',
        data: {},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
	        	$('#periodo-letivo-professor').append($('<option>', {
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

function getAllGrupos() {
    $.ajax({
        url: 'entrada?acao=GetAllGrupos',
        data: {},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
	        	var row = 
	        		"<tr>" +
						"<th scope='row'>" + data[i].numero_grupo + "</th> " +
						"<td>" + data[i].nome + "</td> " +
						"<td>" + data[i].professor.nome + "</td> " +
						"<td><a class='effectclick' data-target='#mostraAlunoGrupo' data-toggle='modal'>Ver Alunos</a></td> " +
					"</tr>";
	        	$('#tableGrupos>tbody').append(row);
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

function filtroTurmasByPeriodoLetivo() {
	var periodoSelecionado = $('#periodo-letivo-professor').val().split("/");
    $.ajax({
        url: 'entrada?acao=FiltroTurmasByPeriodo',
        data: {ano_letivo: periodoSelecionado[0], semestreLetivo: periodoSelecionado[1] },
        type: 'POST',
        success: function (data) {
        	console.log(data);
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


$(function(){
	getPeriodoProfessor();
	getAllGrupos();
});