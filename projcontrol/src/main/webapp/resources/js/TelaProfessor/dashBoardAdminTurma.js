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

function deletaLinhaTabela(turma_id) {

    Swal.fire({
        title: 'Voc&ecirc; tem centeza?',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim, Remover Turma!'
    }).then((result) => {
        if (event.target.className == "delete_turma") {
            event.target.parentNode.parentNode.parentNode.remove();
        } else {
            event.target.parentNode.parentNode.remove();
        }
        if (result.value) {
            deleteTurma(turma_id);
        }
    })
}

function getListarTurma() {
    document.querySelector("#classes").addEventListener("click", ()=>{        
        if(document.querySelector('#tableTurma tbody').children.length == 0){
            if(document.querySelector("#rd_bootstrap").checked){
                $.ajax({
                    url: 'entrada?acao=ListarTurma',
                    data: {},
                    type: 'POST',
                    success: function (dados) {
                        montarGridTurma(dados);
                    },
                    error: function(dados) {
            
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

function montarGridTurma(data) {

    $('#tableTurma>tbody>tr').remove();
    for (i = 0; i < data.length; i++) {
        var row = "<tr>" +
            "<th scope='row' id='botao-deletar' class='nao-deleta-linha'><a id='deletaLinhaTabela' onclick='deletaLinhaTabela(" + data[i].codigoIdentificador + ")'><img src='./resources/assets/trash-solid.png' alt='delete_turma' class='delete_turma'></a></th>" +
            "<td>" + data[i].sigla + "</td>" +
            "<td>" + data[i].turmaTema.titulo + "</td>" +
            "<td>" + data[i].semestreLetivo + "/" + data[i].anoLetivo + "</td>" +
            "<td>" +
            "<button data-toggle='modal' data-target='#vinculaAlunosTurma' type='button' id='vincular-aluno' class='btn btn-danger btn-sm'  onclick='getAlunoVinculo(" + data[i].semestreLetivo + ',' + data[i].anoLetivo + ',' + data[i].codigoIdentificador + ")'>Vincular Aluno</button>" +
            "</td>" +
            "</tr>";

        $('#tableTurma>tbody').append(row);
    }
}

var turma = 0;
function getAlunoVinculo(semestreLetivo, anoLetivo, turmaId) {
    turma = turmaId;
    ids = [];
    $.ajax({
        url: 'entrada?acao=GetAlunosVinculo',
        data: { semestre: semestreLetivo, ano: anoLetivo },
        type: 'POST',
        success: function (data) {
            for (i = 0; i < data.length; i++) {
                var conteudo =
                    "<div class='input-group mb-2 check-name-alunos'>" +
                    "<div class='input-group-prepend'>" +
                    "<div style='display:flex!important' class='input-group-text'>" +
                    "<input id='input-checkBox' class='aluno-bug' value='" + data[i].id + "' type='checkbox' onclick='setIdAluno(" + data[i].id + ")'>" +
                    "</div>" +
                    "</div>" +
                    "<input type='text' disabled class='form-control aluno-bug nomeAlunoFiltro' value='" + data[i].nome + ' (RA) ' + data[i].ra + "'>" +
                    "</div>";

                $('#modalVinculo').append(conteudo);
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

var ids = [];
function setIdAluno(id) {
    ids.push(id);
    console.log(ids);
}

function vincularAlunoTurma() {
    console.log(turma);
    console.log(ids);
    $('#campoIdAlunos').val(ids);
    $.ajax({
        url: 'entrada?acao=VincularAlunoTurma',
        data: { alunosIds: $('#campoIdAlunos').val(), turma_id: turma },
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

function filtraNomesCheckbox() {
    var filtro = document.querySelector("#filtra-nomes-checkbox");

    filtro.addEventListener("input", function () {
        var alunos = document.querySelectorAll('.aluno-bug');
        var boxes = document.querySelectorAll("#input-checkBox");

        if (this.value.length > 0) {
            for (var i = 0; i < alunos.length; i++) {
                var aluno = alunos[i];
                var nome = aluno.value;
                var expressao = new RegExp(this.value, "i");
                if (!expressao.test(nome)) {
                    aluno.parentNode.classList.add("invisivel");
                } else {
                    aluno.parentNode.classList.remove("invisivel");
                }
            }
        } else {
            for (var i = 0; i < alunos.length; i++) {
                var aluno = alunos[i];
                aluno.parentNode.classList.remove("invisivel");
            }
        }

    });
}

function resetaCheckbox() {

    document.querySelector("#resetaCheck").addEventListener("click", () => {
        document.querySelector("#filtra-nomes-checkbox").value = "";
        let alunos = document.querySelectorAll(".aluno-bug");
        for (var i = 0; i < alunos.length; i++) {
            alunos[i].checked = false;
        }
    });

}


function deleteTurma(turma_id) {

    $.ajax({
        url: 'entrada?acao=DeletarTurma',
        data: { turma_id: turma_id },
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
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })

        }
    });
}

$(window).on("load", () => {
    resetaCheckbox();
    filtraNomesCheckbox()
});