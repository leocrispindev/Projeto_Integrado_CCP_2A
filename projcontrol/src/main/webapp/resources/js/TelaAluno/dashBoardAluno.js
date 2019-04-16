
function trocaSenha(){

    $('#trocar-senha').on("click",()=>{
        Swal.mixin({
            input: 'email',
            confirmButtonText: 'Proximo &rarr;',
            showCancelButton: true,
            progressSteps: ['1', '2']
          }).queue([
            {
              title: 'Alterar Email',
              text: 'Digite seu Email atual'
            },
            'Digite seu novo Email',
          ]).then((result) => {
            if (result.value) {
                         
                setUpdateEmail(result.value);
            }
          })

    });
}

trocaSenha();
function setUpdateEmail(dados) {
    $.ajax({
        url: 'entrada?acao=EditarEmail',
        data: {email: dados[0], confirm_email: dados[1]},
        type: 'POST',
        success: function (data) {
          Swal.fire({
            title: data[0],
            text: data[1],
            type: data[2],
            confirmButtonText: 'OK'
        	})
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