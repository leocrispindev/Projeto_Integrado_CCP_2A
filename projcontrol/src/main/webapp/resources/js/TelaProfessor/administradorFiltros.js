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
        	console.log(data);
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

$(function(){
	getPeriodoLetivo();
});