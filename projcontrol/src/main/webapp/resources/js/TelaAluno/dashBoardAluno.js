function trocaEmail(){
  
  $('#troca-email').on("click",()=>{
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


function trocaSenha(){
  
  $('#troca-senha').on("click",()=>{
    Swal.mixin({
      input: 'password',
      confirmButtonText: 'Proximo &rarr;',
      showCancelButton: true,
      progressSteps: ['1', '2','3']
    }).queue([
      {
        title: 'Digite sua Senha:',
      },
      'Digite sua nova Senha',
      'Confirme sua nova Senha'
    ]).then((result) => {
      if (result.value) {
        setUpdateSenha(result.value);
      }
    })
    
  });
}

trocaEmail();
trocaSenha();

function setUpdateEmail(dados) {
  $.ajax({
    url: 'entrada?acao=UpdateCredenciais',
    data: {campo: dados[0], confirm_campo: dados[1], update:"email"},
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

function setUpdateSenha(dados) {
  $.ajax({
    url: 'entrada?acao=UpdateCredenciais',
    data: {campo: dados[1], confirm_campo: dados[2], update:"senha"},
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