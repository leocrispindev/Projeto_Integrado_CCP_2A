
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
                title: data[0],
                text: data[1],
                type: data[2],
                confirmButtonText: 'OK'
            })
            
            enviaEmailPosRegistro(email,nome);
        },
        error: function(data) {
            
            Swal.fire({
                title: 'Error!',
                text: data[1],
                type: 'error',
                confirmButtonText: 'OK'
            })
            
        }
    });
}

function enviaEmailPosRegistro(email,nome){
    $.ajax({
        url: 'entrada?acao=EnviarEmailCadastrar',
        data: {
            env_email: email, 
            env_nome: nome
        },
        type: 'POST',
        success: function (data) {
            
            const Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 5000
            });
            
            console.log(data);
            Toast.fire({
                type: 'success',
                title: data[0] + " Enviamos um email para o endere&ccedilo cadastrado!"
            })
            
        },
        error: function (data) {
            
            const Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 5000
            });
            
            Toast.fire({
                type: data[2],
                title: data[1]
            })
            
        },
    });
    
}

function enviaNotificacaoAposRecuperarSenha(){
    

    var emailParaSerRecuperado = $('#recuperarEmail').val();
    
    $.ajax({
        url: 'entrada?acao=GetEmailTrocaSenha',
        data: {email: emailParaSerRecuperado},
        type: 'POST',
        success: function (data) {
            
            const Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 5000
            });
            
            console.log(data);
            Toast.fire({
                type: 'success',
                title: data[1]
            })


            
        },
        error: function (data) {
            
            const Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 5000
            });
            
            
            Toast.fire({
                type: 'warning',
                title: 'Ops! Tivemos Alguns Problemas, n&atildeo foi possivel recuperar a senha'
            })

            
        },
    });
    
}

