import Swal from 'sweetalert2';
function animaAvatar(){
    
    $(document).ready(function() {
        $('#avatar-usuario').removeClass('avatar-usuario');
        $('#avatar-usuario').addClass('avatar-usuario-carregado');
    });
    
}

function animaDeslogar(){

    $(".deslogar").on("mouseover",()=>{
        $(".deslogarFas").removeClass('fa-door-closed');
        $(".deslogarFas").addClass('fa-door-open');
    });

}



function animaEscritaTexto(id){
    
    try{
        const titulo = document.querySelector(`${id}`); 
    
        if(titulo == null){
            
        }else{
            
            const textoArray = titulo.innerHTML.split('');
            titulo.innerHTML = '';
            textoArray.forEach((letra, i) =>{
                setTimeout( () => titulo.innerHTML += letra
                , 155 * i);
            });
        }
    }catch{
        
    }
    
}

function scrollDetect(){

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

    $('#rd_angular').on("click",()=>{
        $('.sections').css('margin-top','-300vh');
        
        rd_angular.attr("checked",true);
        rd_nodejs.removeAttr("checked"); 
        rd_bootstrap.removeAttr("checked"); 
        rd_sass.removeAttr("checked");
        rd_ruby.removeAttr("checked"); 
    });
    
}


export{animaAvatar,animaEscritaTexto,scrollDetect,animaDeslogar};