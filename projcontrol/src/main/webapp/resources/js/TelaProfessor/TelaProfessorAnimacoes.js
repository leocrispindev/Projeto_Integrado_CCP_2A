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



function scrollDetectProf(){

    var rd_nodejs = $('#rd_nodejs');
    var rd_bootstrap = $('#rd_bootstrap');
    var rd_sass = $('#rd_sass');
    if(rd_ruby = $('#rd_ruby')){
        var rd_ruby = $('#rd_ruby');
    }
    var rd_angular = $('#rd_angular');

    $('#rd_nodejs').on("click",()=>{
        $('.sections').css('margin-top','0vh');

        rd_nodejs.attr("checked",true);
        rd_bootstrap.removeAttr("checked"); 
        rd_sass.removeAttr("checked"); 
        rd_ruby.removeAttr("checked"); 
        rd_angular.removeAttr("checked"); 
    });

    $('#rd_bootstrap').on("click",()=>{
        $('.sections').css('margin-top','-100vh');

        rd_bootstrap.attr("checked",true);
        rd_nodejs.removeAttr("checked"); 
        rd_sass.removeAttr("checked"); 
        rd_ruby.removeAttr("checked"); 
        rd_angular.removeAttr("checked"); 
    });

    $('#rd_sass').on("click",()=>{
        $('.sections').css('margin-top','-200vh');

        rd_sass.attr("checked",true);
        rd_nodejs.removeAttr("checked"); 
        rd_ruby.removeAttr("checked"); 
        rd_bootstrap.removeAttr("checked"); 
        rd_angular.removeAttr("checked"); 
    });

    $('#rd_ruby').on("click",()=>{
        $('.sections').css('margin-top','-300vh');

        rd_ruby.attr("checked",true);
        rd_nodejs.removeAttr("checked"); 
        rd_bootstrap.removeAttr("checked"); 
        rd_angular.removeAttr("checked"); 
        rd_sass.removeAttr("checked");
    });

    $('#rd_angular').on("click",()=>{
        $('.sections').css('margin-top','-400vh');
        
        rd_angular.attr("checked",true);
        rd_nodejs.removeAttr("checked"); 
        rd_bootstrap.removeAttr("checked"); 
        rd_sass.removeAttr("checked");
        rd_ruby.removeAttr("checked"); 
    });

    $('body').on('keydown', function(event) {

        var tecla = event.keyCode;        

        if(tecla == 38 || tecla == 37) {            

            // seta pra CIMA
            if(rd_angular.prop("checked")){
                $('.sections').css('margin-top','-300vh');
                rd_ruby.attr("checked",true);  

                rd_angular.removeAttr("checked");
                rd_nodejs.removeAttr("checked");
                rd_sass.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");

            }else if(rd_ruby.prop("checked")){
                $('.sections').css('margin-top','-200vh');
                rd_sass.attr("checked",true);

                rd_ruby.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");
                rd_nodejs.removeAttr("checked");
                rd_angular.removeAttr("checked");

            }else if(rd_sass.prop("checked")){
                $('.sections').css('margin-top','-100vh');
                rd_bootstrap.attr("checked",true);

                rd_ruby.removeAttr("checked");
                rd_nodejs.removeAttr("checked");
                rd_angular.removeAttr("checked");
                rd_sass.removeAttr("checked");

            }else if(rd_bootstrap.prop("checked")){
                $('.sections').css('margin-top','0vh');
                rd_nodejs.attr("checked",true);

                rd_ruby.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");    
                rd_angular.removeAttr("checked");
                rd_sass.removeAttr("checked");
            }

        } else if(tecla == 40 || tecla == 39) {
            console.log(tecla);
            // seta pra BAIXO

            if(rd_nodejs.prop("checked")){
                $('.sections').css('margin-top','-100vh');
                rd_bootstrap.attr("checked",true);

                rd_angular.removeAttr("checked");
                rd_ruby.removeAttr("checked");
                rd_sass.removeAttr("checked");
                rd_nodejs.removeAttr("checked");

            }else if(rd_bootstrap.prop("checked")){
                $('.sections').css('margin-top','-200vh');
                rd_sass.attr("checked",true);

                rd_angular.removeAttr("checked");
                rd_ruby.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");
                rd_nodejs.removeAttr("checked");

            }else if(rd_sass.prop("checked")){
                $('.sections').css('margin-top','-300vh');
                rd_ruby.attr("checked",true);

                rd_nodejs.removeAttr("checked");
                rd_sass.removeAttr("checked");
                rd_angular.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");

            }else if(rd_ruby.prop("checked")){
                $('.sections').css('margin-top','-400vh');
                rd_angular.attr("checked",true);

                rd_nodejs.removeAttr("checked");
                rd_sass.removeAttr("checked");
                rd_ruby.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");

            }else if(rd_angular.prop("checked")){
                $('.sections').css('margin-top','0vh');
                rd_nodejs.attr("checked",true);

                rd_sass.removeAttr("checked");
                rd_ruby.removeAttr("checked");
                rd_bootstrap.removeAttr("checked");
                rd_angular.removeAttr("checked");
            }
        }

    });

    
}



export{deleteBtn,deletaOCard,deletaLinhaTabela,};