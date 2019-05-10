function setCadastroTurma() {
    var anoLetivo = $('#anoLetivoRegister').val();
    var sigla = $('#siglaRegister').val();
    var semestreLetivo = $('#semestreLetivoRegister').val();
    var tema = $('#temaRegister').val();

    $.ajax({
        url: 'entrada?acao=CadastrarTurma',
        data: { anoLetivo: anoLetivo, sigla: sigla, semestreLetivo: semestreLetivo, tema: tema },
        type: 'POST',
        success: function (data) {

            Swal.fire({
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })

            getListarTurma();
        },
        error: function (data) {
            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })

        }
    });
}

function getTemas() {
    $.ajax({
        url: 'entrada?acao=GetTema',
        data: {},
        type: 'POST',
        success: function (data) {
            $('#temaRegister').children().remove().end();
            $('#temaRegister').prepend('<option style="color: #6c757d;" disabled selected>Ex: Desenvolvimento Web</option>');
            for (i = 0; i < data.length; i++) {
                $('#temaRegister').append($('<option>', {
                    value: data[i].tema_id,
                    text: data[i].titulo
                }));
            }
        },
        error: function (data) {
            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })

        }
    });
}

function getListarTurma() {
    
    $.ajax({
        url: 'entrada?acao=ListarTurma',
        data: {},
        type: 'POST',
        success: function (dados) {
            montarGridTurma(dados);
        },
        error: function(dados) {
            console.log(dados);

            Swal.fire({
                title: 'Error!',
                text: 'Erro ao retornar os dados.Contate o adminstrador do sistema.',
                type: 'error',
                confirmButtonText: 'OK'
            })
            
        }
    });
}

function montarGridTurma(data) {
    $('#tableTurma>tbody>tr').remove();
    for(i=0; i<data.length; i++) {
        var row = "<tr>" +
                    "<th scope='row' id='botao-deletar' class='nao-deleta-linha'><a id='deletaLinhaTabela'><img src='./resources/assets/trash-solid.png' alt='delete_turma' class='delete_turma'></a></th>" +
                    "<td>" + data[i].sigla + "</td>" +
                    "<td>" + data[i].turmaTema.titulo + "</td>" +
                    "<td>" + data[i].semestreLetivo + "/" + data[i].anoLetivo + "</td>" +
                    "<td>"+
                        "<button data-toggle='modal' data-target='#vinculaAlunosTurma' type='button' id='vincular-aluno' class='btn btn-danger btn-sm' onclick=''>Vincular Aluno</button>" +
                        "<button style='margin-left:3px;' data-toggle='modal' data-target='#desvinculaAlunosTurma' type='button' id='vincular-aluno' class='btn btn-primary btn-sm' onclick=''>Desvincular Aluno</button>" +
                        "</td>" +
                "</tr>";

        $('#tableTurma>tbody').append(row);
    }
}