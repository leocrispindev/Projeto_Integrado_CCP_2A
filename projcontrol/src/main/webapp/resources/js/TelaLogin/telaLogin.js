
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
<<<<<<< HEAD
            Swal.fire({
                title: 'Error!',
                text: 'Erro ai po',
                type: 'error',
                confirmButtonText: 'Cool'
              })
            console.log(data)
=======
            
            Swal.fire({
                title: 'Error!',
                text: data,
                type: 'error',
                confirmButtonText: 'OK'
            })
>>>>>>> 54f43b83f2f78e1702d225bb91b9f3be831c832b
        }
    });
}