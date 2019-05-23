function getAvaliacoes() {
    $.ajax({
        url: 'entrada?acao=GetAvaliacoes',
        data: {turma: $('#turma').val(), professor: $('#professor').val(), grupo:$('#grupo').val()},
        type: 'POST',
        success: function (data) {
            montargrid(data);
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

function montargrid(data) {
    $('#tableAvaliacao>tbody>tr').remove();
    for(i=0; i<data.length; i++) {
        var row = "<tr>" +
        "<td>" + data[i].avaliacaoId + "</td>" +
        "<td>" + data[i].nota + "</td>" +
        "<td>" + data[i].turma.sigla  + "</td>" +
        "<td>" + data[i].grupo.nome+ "</td>" +
        "<td>" + data[i].grupo.professor.nome + "</td>" +
        `<td><button data-toggle="modal" data-target="#modalAvaliacoes" class="btn btn-danger btn-sm">Ver informa&ccedil&otildees</button></td>`
        "</tr>";
        
        $('#tableAvaliacao>tbody').append(row);
    }
}


function getAlunos() {
    var parametro = $('#filtra-nomes').val();
    document.querySelector("#label-custom").addEventListener('click', () =>{
        $.ajax({
            url: 'entrada?acao=ListarAlunos',
            data: {nome: parametro},
            type: 'POST',
            success: function (data) {
                montargridAlunos(data);
            },
            error: function(data) {
                console.log(data)
                Swal.fire({
                    title: 'Error!',
                    text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                    type: 'error',
                    confirmButtonText: 'OK'
                })
                
            }
        });
    });
}

function montargridAlunos(data) {
    $('#tableAlunos>tbody>tr').remove();
    for(i=0; i<data.length; i++) {
        var row = "<tr id='aluno'>" +
        "<th id='raAluno' scope='row'>"+ data[i].ra + "</th>" +
        "<td id='nomeAluno'>" + data[i].nome + "</td>" +
        "<td>" + data[i].email  + "</td>" +
        "<td><button type='button' id='deleta-aluno' class='btn btn-danger btn-sm' onclick='confirmDeleteAdmin("+ data[i].id+")'>Excluir</button></td>" +
        "<td><button data-toggle='modal' data-target='.informacoes-aluno-modal' type='button' class='btn btn-primary btn-sm' onclick='getDadosAluno("+ data[i].id+")'>Ver Informa&ccedil&otildees</button></td>" +
        "</tr>";
        
        $('#tableAlunos>tbody').append(row);
    }
}

/*function confirmDeleteAdmin(){
    
    if(document.querySelectorAll('#deleta-aluno') != null){
        
        let alunos = document.querySelectorAll('#deleta-aluno');
        for( var i = 0; i < alunos.length; i++ ){
            var aluno = alunos[i];
            aluno.addEventListener("click",(event)=>{
                let alvo = event.target.parentNode.parentNode;
                Swal.fire({
                    title: `Você tem certeza que deseja deletar ${alvo.querySelector("#nomeAluno").textContent} do sistema?`,
                    text: "Você não vai poder reverter essa alteração!",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Deletar'
                }).then((result) => {
                    if (result.value) {
                        deleteAluno(id)
                    }
                })
            }); 
        }
    }
    
}*/

function confirmDeleteAdmin(id){
    Swal.fire({
        title: `Confirmar a exclusao do usuario?`,
        text: "Voce nao vai poder reverter!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Deletar'
    }).then((result) => {
        if (result.value) {
            deleteAluno(id)
        }
    })         
}
function deleteAluno(id) {
    var usuId = id;
    $.ajax({
        url: 'entrada?acao=DeletarAluno',
        data: {usu_id: usuId},
        type: 'POST',
        success: function (data) {
            Swal.fire({
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })
            getAlunos();
        },
        error: function(data) {
            Swal.fire({
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })
            
        }
    });
}

function getDadosAluno(id) {
    var row = '';
    $.ajax({
        url: 'entrada?acao=DadosAluno',
        data: {usu_id: id},
        type: 'POST',
        success: function (data) {
            
            $('#alunoDadosRA').text("RA: "+data.ra);
            $('#alunoDadosNOME').text(data.nome);
            $('#alunoDadosEMAIL').text(data.email);
            $('#alunoDadosQtdTurmas').text("Quantidade de Turmas: "+data.turmas.length);
            for(i=0; i<data.turmas.length; i++) {
                row+= data.turmas[i].sigla + ' ';
            }
            $('#alunoDadosTurmas').text("Turmas: "+row);
            let dropdown = $("#dropdownTurmas");
            for(i=0; i<data.turmas.length; i++) {
                dropdown.append(`<a class="dropdown-item" onclick="modalConfirm(${data.id}, ${data.turmas[i].codigoIdentificador} )" href="#">${data.turmas[i].sigla}</a>`);
            }
        },
        error: function(data) {
            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados do aluno.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })
            
        }
    });
}


function modalConfirm(idAluno, idTurma){
    
    Swal.fire({
        title: 'Voce tem certeza disso?',
        text: "Voce nao podera reverter isso!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim, Desvincular'
    }).then((result) => {
        if (result.value) {
            desvincularAlunoTurma(idAluno,idTurma)
        }
    })
}


function desvincularAlunoTurma(idAluno, idTurma) {
    $.ajax({
        url: 'entrada?acao=DesvincularAlunoTurma',
        data: {idAluno: idAluno, idTurma: idTurma},
        type: 'POST',
        success: function (data) {
            Swal.fire({
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })
        },
        error: function(data) {
            Swal.fire({
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })
            
        }
    });
}

















