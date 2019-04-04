
function setCadastroAluno() {
    var nome = $('#userNomeRegister').val();
    var ra = $('#userRaRegister').val();
    var email = $('#userEmailRegister').val();
    var senha = $('#userPasswordRegister').val();

    $.ajax({
        url: 'entrada?acao=CadastrarAluno',
        data: {usu_nome: nome, usu_email: email, usu_ra: ra, usu_senha: senha},
        type: 'POST',
        success: function (data) {
        	 Swal.fire({
        	        title: 'Sucesso!',
        	        text: data,
        	        type: 'success',
        	        confirmButtonText: 'OK'
        	    })
        },
        error: function(data) {
            
            Swal.fire({
                title: 'Error!',
                text: data,
                type: 'error',
                confirmButtonText: 'OK'
            })
        }
    });
}