function buscarGrupos() {
    $.ajax({
        url: 'entrada?acao=GetGrupos',
        data: {turmaId: $('#grupo-turma-combobox').val() , professorId: $('#grupo-professor-combobox').val()},
        type: 'POST',
        success: function (data) {
        	 $('#tableGrupos>tbody>tr').remove();
        	 montargridGruposFiltrados(data);
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

function montargridGruposFiltrados(data) {
    let identificadorDaTrAlunos = 0;
    let tdId = 1;
	for(let i = 0; i < data.length; i++) {
    	var row = 
    		"<tr>" +
				"<th scope='row'>" + data[i].numero_grupo + "</th> " +
				"<td class='grupo-id' hidden='true' id='g" + tdId + "'>" + data[i].id + "</td> " +
				"<td>" + data[i].nome + "</td> " +
				"<td>" + data[i].professor.nome + "</td> " +
				"<td><a data-toggle='collapse' data-target= '#esconde" + identificadorDaTrAlunos + "' class='effectclick'>Visualizar &or;</a></td> " +
            "</tr>"+
            "<tr class='collapse style-alunos' aria-expanded='false' id='esconde" + identificadorDaTrAlunos + "'> " +
                "<th></th> " +
                "<td><td> " +
                "<td class='tdAlunos'></td>" +
            "</tr> ";

        $('#tableGrupos>tbody').append(row);
        tableGruposListarAlunos(tdId);
        identificadorDaTrAlunos++;
        tdId++;
	}
}

function getPeriodoProfessor() {
	//onLoad = document.getElementById('periodo-letivo-professor').options[0].selected = 'selected';
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

function tableGruposListarGrupos() {
    document.querySelector("#group").addEventListener("click", ()=>{        
        if(document.querySelector('#tableGrupos tbody').children.length == 0){
            if(document.querySelector("#rd_sass").checked){
                $.ajax({
                    url: 'entrada?acao=GetAllGrupos',
                    data: {},
                    type: 'POST',
                    success: function (data) {
                        montargridAllGrupos(data);
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
    });

    document.addEventListener('keydown', () =>{
        if((event.keyCode == 37 || event.keyCode == 38 || event.keyCode == 39 || event.keyCode == 40) && document.querySelector('#tableGrupos tbody').children.length == 0){
            if(document.querySelector("#rd_sass").checked){
                $.ajax({
                    url: 'entrada?acao=GetAllGrupos',
                    data: {},
                    type: 'POST',
                    success: function (data) {
                        montargridAllGrupos(data);
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
    });
}

function montargridAllGrupos(data) {
    let identificadorDaTrAlunos = 0;
    let tdId = 1;
	for(let i = 0; i < data.length; i++) {
    	var row = 
    		"<tr>" +
				"<th scope='row'>" + data[i].numero_grupo + "</th> " +
				"<td class='grupo-id' hidden='true' id='g" + tdId + "'>" + data[i].id + "</td> " +
				"<td>" + data[i].nome + "</td> " +
				"<td>" + data[i].professor.nome + "</td> " +
				"<td><a data-toggle='collapse' data-target= '#esconde" + identificadorDaTrAlunos + "' class='effectclick'>Visualizar &or;</a></td> " +
            "</tr>"+
            "<tr class='collapse style-alunos' aria-expanded='false' id='esconde" + identificadorDaTrAlunos + "'> " +
                "<th></th> " +
                "<td><td> " +
                "<td class='tdAlunos'></td>" +
            "</tr> ";

        $('#tableGrupos>tbody').append(row);
        tableGruposListarAlunos(tdId);
        identificadorDaTrAlunos++;
        tdId++;
	}
}

function tableGruposListarTurmas() {
    $.ajax({
        url: 'entrada?acao=ListarTurma',
        data: {},
        type: 'POST',
        success: function (data) { 	
        	for(i = 0; i < data.length; i++) {
	        	$('#grupo-turma-combobox').append($('<option>', {
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

function tableGruposListarProfessores() {
    $.ajax({
        url: 'entrada?acao=FiltroProfessores',
        data: {},
        type: 'POST',
        success: function (data) {
        	for(i = 0; i < data.length; i++) {
        		$('#grupo-professor-combobox').append($('<option>', {
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

function tableGruposFiltroProfessores() {
	let periodo = $('#periodo-letivo-professor').val().split("/");
    $.ajax({
        url: 'entrada?acao=FiltroProfessoresByPeriodo',
        data: {anoLetivo: periodo[0], semestreLetivo: periodo[1]},
        type: 'POST',
        success: function (data) {
        	$('#grupo-professor-combobox').children().remove().end();
        	$('#grupo-professor-combobox').prepend('<option selected>Professor</option>');
        	
        	for(i = 0; i < data.length; i++) {
        		$('#grupo-professor-combobox').append($('<option>', {
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

function tableGruposFiltroTurmas() {
	let periodo = $('#periodo-letivo-professor').val().split("/");
    $.ajax({
        url: 'entrada?acao=FiltroTurmasByPeriodo',
        data: {ano_letivo: periodo[0], semestreLetivo: periodo[1]},
        type: 'POST',
        success: function (data) {
        	$('#grupo-turma-combobox').children().remove().end();
        	$('#grupo-turma-combobox').prepend('<option selected>Turma</option>');
        	
        	for(i = 0; i < data.length; i++) {
	        	$('#grupo-turma-combobox').append($('<option>', {
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

function tableGruposListarAlunos(posicao){
	let gId = $('#g' + posicao).text();
        $.ajax({
            url: 'entrada?acao=PreencherGrupos',
            data: {grupoId: gId},
            type: 'POST',
            success: function (data) {
                let alunos = document.querySelectorAll('.tdAlunos');
                for(j = 0; j < data.length; j++) {                
                	var aluno = 
                		data[j].ra + " | " + data[j].nome;
                	$(alunos[posicao - 1]).append(aluno + "</br>");
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

function tableGruposFiltros() {
	tableGruposFiltroTurmas();
	tableGruposFiltroProfessores();
}

$(function(){
	getPeriodoProfessor();
	tableGruposListarTurmas();
	tableGruposListarProfessores();
});