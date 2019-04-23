import Swal from 'sweetalert2';

function deleteBtn(){
    
    $('.btn-delete').on("click",()=>{
        
        var botoes = $(".botao-fechar");
        
        for(var i = 0; i < botoes.length; i++){
            if(botoes[i].classList.contains('close-bar')){
            
                botoes[i].classList.remove('close-bar');
                
            }else{
                
                botoes[i].classList.add('close-bar');                
            } 
        }       
       
        deletaOCard();
    });
    
}


function deletaOCard(){

    if(document.querySelectorAll("#botao-deletar") != null){
        
        var lixeiras = document.querySelectorAll("#botao-deletar");        

        for(var i = 0; i < lixeiras.length; i++){
            if(lixeiras[i].classList.contains("nao-deleta-linha")){

                for(var i = 0; i < lixeiras.length; i++){
                    lixeiras[i].classList.add("deleta-linha");
                    lixeiras[i].classList.remove("nao-deleta-linha");
                }
               
            }else{
                
                for(var i = 0; i < lixeiras.length; i++){
                    lixeiras[i].classList.remove("deleta-linha");
                    lixeiras[i].classList.add("nao-deleta-linha");
                }
        
            }
        }

    }
    
}

function deletaLinhaTabela(){
    
    if(document.querySelectorAll("#deletaLinhaTabela") != null){
        var del = document.querySelectorAll("#deletaLinhaTabela");
        
        for(var i = 0; i < del.length; i++){
                        
            del[i].addEventListener("click",(event)=>{

                Swal.fire({
                    title: 'Você tem centeza?',
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Sim, Remover Turma!'
                  }).then((result) => {
                    if (result.value) {
                      Swal.fire(
                        'Turma Removida',
                        $(event.target).parent().parent().parent().parent().remove(),
                        'success'
                      )
                    }
                  })
            });        
        }

    }

}

function filtraNomes(){

    var filtro = document.querySelector("#filtra-nomes");

    filtro.addEventListener("input", function(){
        var alunos = document.querySelectorAll('#aluno');
        console.log(alunos);
        

        if( this.value.length > 0){
            for(var i = 0; i < alunos.length; i++){
                var aluno = alunos[i];
                var tdNome = aluno.querySelector("#nomeAluno");                
                var nome = tdNome.textContent;      
                var expressao = new RegExp(this.value,"i");
                if( !expressao.test(nome)){
                    aluno.classList.add("invisivel");                    
                }else{
                    aluno.classList.remove("invisivel");                    
                }
            }
        }else{
            for(var i = 0; i < alunos.length; i++){
                var aluno = alunos[i];
                aluno.classList.remove("invisivel");                
            }
        }

    });

}


export{deleteBtn,deletaOCard,deletaLinhaTabela,filtraNomes};