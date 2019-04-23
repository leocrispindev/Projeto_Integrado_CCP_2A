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

    let obj = document.getElementById('scroll_control').style;
    obj.marginTop = 0 + 'vh';

    let information = document.getElementById('information').addEventListener('click', () =>{
        obj.marginTop = 0;
    });
    let classes = document.getElementById('classes').addEventListener('click', () =>{
        obj.marginTop = -100 + 'vh';
    });
    let group = document.getElementById('group').addEventListener('click', () =>{
        obj.marginTop = -200 + 'vh';
    });
    let schedule = document.getElementById('schedule').addEventListener('click', () =>{
        obj.marginTop = -300 + 'vh';
    });

    document.addEventListener('keydown', () =>{
        
        let tecla = event.keyCode;
        if(tecla == 37 || tecla == 38){

                if(obj.marginTop == 0 + 'vh'){
                    obj.marginTop = -300 + 'vh';
                }else if(obj.marginTop == -300 + 'vh'){
                    obj.marginTop = -200 + 'vh';
                }else if(obj.marginTop == -200 + 'vh'){
                    obj.marginTop = -100 + 'vh';
                }else if(obj.marginTop == -100 + 'vh'){
                    obj.marginTop = 0 + 'vh';
                }
        }

        if(tecla == 39 || tecla == 40){
                
            if(obj.marginTop == -300 + 'vh'){
                obj.marginTop = 0 + 'vh';
            }else if(obj.marginTop == -200 + 'vh'){
                obj.marginTop = -300 + 'vh';
            }else if(obj.marginTop == -100 + 'vh'){
                obj.marginTop = -200 + 'vh';
            }else if(obj.marginTop == 0 + 'vh'){
                obj.marginTop = -100 + 'vh';
            }
        }
    });
    
}


export{animaAvatar,animaEscritaTexto,scrollDetect,animaDeslogar};