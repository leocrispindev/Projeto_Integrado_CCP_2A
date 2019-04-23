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
                "</tr>";

        $('#tableAvaliacao>tbody').append(row);
    }
}
$(function(){

    getAvaliacoes();
  
  });