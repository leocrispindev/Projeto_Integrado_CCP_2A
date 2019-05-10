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
            let identificadorDaTrAlunos = 0;
        	for(i = 0; i < data.length; i++) {
	        	var row = 
	        		"<tr>" +
						"<th scope='row'>" + data[i].numero_grupo + "</th> " +
						"<td>" + data[i].nome + "</td> " +
						"<td>" + data[i].professor.nome + "</td> " +
						`<td><a data-toggle='collapse' data-target='#esconde${identificadorDaTrAlunos}' class='effectclick'>Ver Alunos &or;</a></td> ` +
                    "</tr>"+
                    `<tr class='collapse style-alunos' aria-expanded="false" id='esconde${identificadorDaTrAlunos}'>
                        <th></th>
                        <td><td>
                        <td>Izuku Midoriya <br/> Ochako Uraraka<br/> Todoroki shoto<br/> Uzumaki Naruto <td>
                    </tr>`;
                $('#tableGrupos>tbody').append(row);
                identificadorDaTrAlunos++;
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