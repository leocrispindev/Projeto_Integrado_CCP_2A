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

function scrollDetect() {

  if(document.getElementById('scroll_control') != null){
    let obj = document.getElementById('scroll_control').style;
    obj.marginTop = 0 + 'vh';
    let input1 = document.getElementById('rd_nodejs');
    let input2 = document.getElementById('rd_bootstrap');
    let input3 = document.getElementById('rd_sass');
    let input4 = document.getElementById('rd_angular');
    document.getElementById('information').addEventListener('click', function () {
      obj.marginTop = 0 + 'vh';
    });
    input1.addEventListener('click', function () {
      input1.checked = true;
      input2.checked, input3.checked, input4.checked = false;
      obj.marginTop = 0 + 'vh';
    });
    document.getElementById('classes').addEventListener('click', function () {
      obj.marginTop = -100 + 'vh';
    });
    input2.addEventListener('click', function () {
      input2.checked = true;
      input1.checked, input3.checked, input4.checked = false;
      obj.marginTop = -100 + 'vh';
    });
    document.getElementById('group').addEventListener('click', function () {
      obj.marginTop = -200 + 'vh';
    });
    input3.addEventListener('click', function () {
      input3.checked = true;
      input2.checked, input1.checked, input4.checked = false;
      obj.marginTop = -200 + 'vh';
    });
    document.getElementById('schedule').addEventListener('click', function () {
      obj.marginTop = -300 + 'vh';
    });
    input4.addEventListener('click', function () {
      input4.checked = true;
      input2.checked, input3.checked, input1.checked = false;
      obj.marginTop = -300 + 'vh';
    });
    document.addEventListener('keydown', function () {
      var tecla = event.keyCode;
  
      if (tecla == 37 || tecla == 38) {
        if (obj.marginTop == 0 + 'vh') {
          obj.marginTop = -300 + 'vh';
          input1.checked = false;
          input4.checked = true;
        } else if (obj.marginTop == -300 + 'vh') {
          obj.marginTop = -200 + 'vh';
          input4.checked = false;
          input3.checked = true;
        } else if (obj.marginTop == -200 + 'vh') {
          obj.marginTop = -100 + 'vh';
          input3.checked = false;
          input2.checked = true;
        } else if (obj.marginTop == -100 + 'vh') {
          obj.marginTop = 0 + 'vh';
          input2.checked = false;
          input1.checked = true;
        }
      }
  
      if (tecla == 39 || tecla == 40) {
        if (obj.marginTop == -300 + 'vh') {
          obj.marginTop = 0 + 'vh';
          input4.checked = false;
          input1.checked = true;
        } else if (obj.marginTop == -200 + 'vh') {
          obj.marginTop = -300 + 'vh';
          input3.checked = false;
          input4.checked = true;
        } else if (obj.marginTop == -100 + 'vh') {
          obj.marginTop = -200 + 'vh';
          input2.checked = false;
          input3.checked = true;
        } else if (obj.marginTop == 0 + 'vh') {
          obj.marginTop = -100 + 'vh';
          input1.checked = false;
          input2.checked = true;
        }
      }
    });
  }
    
}


export{animaAvatar,animaEscritaTexto,scrollDetect,animaDeslogar};