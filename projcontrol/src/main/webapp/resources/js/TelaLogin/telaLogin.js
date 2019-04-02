
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
            console.log('Sucesso')
            console.log(data)
        },
        error: function(data) {
            console.log('Erro')
            console.log(data)
        }
    });
}