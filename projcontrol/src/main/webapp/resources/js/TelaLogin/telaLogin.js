
$(window).on("load",()=>{

    Swal.fire({
        title: 'Error!',
        text: 'Do you want to continue',
        type: 'error',
        confirmButtonText: 'Cool'
      })

    //   https://sweetalert2.github.io/#examples da uma lida nos exemplos ai de como usar leozão 
    // não importei o sweet alert no dashboard aluno nem no professor so na tela de login 
});


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
        	        confirmButtonText: 'Cool'
        	      })
        },
        error: function(data) {
            console.log('Erro')
            console.log(data)
        }
    });
}