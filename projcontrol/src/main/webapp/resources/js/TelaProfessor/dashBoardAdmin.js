function getAvaliacoes() {

    $.ajax({
        url: 'entrada?acao=GetAvaliacoes',
        data: {},
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
                "</tr>";

        $('#tableAvaliacao>tbody').append(row);
    }
}

function getAlunos() {
    var parametro = $('#filtra-nomes').val();
    $.ajax({
        url: 'entrada?acao=ListarAlunos',
        data: {nome: parametro},
        type: 'POST',
        success: function (data) {
            montargridAlunos(data);
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

function montargridAlunos(data) {
    $('#tableAlunos>tbody>tr').remove();
    for(i=0; i<data.length; i++) {
        var row = "<tr id='aluno'>" +
                    "<th id='raAluno' scope='row'>"+ data[i].ra + "</th>" +
                    "<td id='nomeAluno'>" + data[i].nome + "</td>" +
                    "<td>" + data[i].email  + "</td>" +
                    "<td><button type='button' class='btn btn-danger btn-sm'>Deletar</button></td> "
                "</tr>";

        $('#tableAlunos>tbody').append(row);
    }
}

function confirmDeleteAdmin(){

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
                    event.target.parentNode.parentNode.remove(),
                      Swal.fire(
                        'Deletado',
                        `O aluno ${alvo.querySelector("#nomeAluno").textContent} foi deletado(a) com sucesso!`,
                        'success'
                      )
                    }
                  })
            }); 
        }
    }
        
}

$(function(){
    getAlunos();
    getAvaliacoes();
    confirmDeleteAdmin();
  });