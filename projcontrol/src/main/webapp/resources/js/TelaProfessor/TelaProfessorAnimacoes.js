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
                    if(event.target.className  == "deleta_turma"){
                        event.target.parentNode.parentNode.parentNode.remove();
                    }else{
                        event.target.parentNode.parentNode.remove();                 
                    }
                    if (result.value) {
                        Swal.fire(
                            'Turma Removida',
                            'success'
                            )
                        }
                    })
                });        
            }
            
        }
        
    }
    
    function filtraNomes(){
        
        if(document.querySelector("#filtra-nomes") != null){
            
            var filtro = document.querySelector("#filtra-nomes");
            
            $("#possiveis-filtros").on("change", ()=>{
                
                if($("#possiveis-filtros").val() == "Ra"){
                    
                    filtro.addEventListener("input", function(){
                        var alunos = document.querySelectorAll('#aluno');        
                        
                        if( this.value.length > 0){
                            for(var i = 0; i < alunos.length; i++){
                                var aluno = alunos[i];
                                var tdRa = aluno.querySelector("#raAluno");                
                                var ra = tdRa.textContent;      
                                var expressao = new RegExp(this.value,"i");
                                if( !expressao.test(ra)){
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
                    
                }else if($("#possiveis-filtros").val() == "Nome"){
                    
                    filtro.addEventListener("input", function(){
                        var alunos = document.querySelectorAll('#aluno');        
                        
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
                
            });
            
            
            
            
        }
    }

    function enableLightMode(){
        
        $('.light-mode').on("change",()=>{
            
            if( $('.light-mode').is(":checked") == true){

                $('.light-mode-text').css("color","#343a40");
                $('#modal-dark').removeClass("modal-dark");
                $('#tableAlunos').removeClass("table-dark")
                $('.light-mode-text').text("Light Mode On");
                $('#mini-user').removeClass("modal-dark");
                $('.corpo-informacoes').removeClass("info-dark");
                $('.titulo-informacoes').removeClass("info-dark");

            }else{

                $('.light-mode-text').css("color","white");
                $('#modal-dark').addClass("modal-dark");
                $('#tableAlunos').addClass("table-dark");
                $('.light-mode-text').text("Dark Mode On");
                $('#mini-user').addClass("modal-dark");
                $('.corpo-informacoes').addClass("info-dark");
                $('.titulo-informacoes').addClass("info-dark");
            }
            
        });
        
    }

    function closeModal(){
        $('#close-modal').on("click",()=>{
            $('.informacoes-aluno-modal').modal('hide');
        });        
    }

    
    
    
    export{deleteBtn,deletaOCard,deletaLinhaTabela,filtraNomes,enableLightMode, closeModal};