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
    if($('.btn-turma') != null){
      $('.btn-turma').css('display', 'none');
    }
    let obj = document.getElementById('scroll_control').style;
    obj.marginTop = 0 + 'vh';
    let input1 = document.getElementById('rd_nodejs');
    let input2 = document.getElementById('rd_bootstrap');
    let input3 = document.getElementById('rd_sass');
    let input4 = document.getElementById('rd_angular');
    document.getElementById('information').addEventListener('click', function () {
      obj.marginTop = 0 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'none');
      }
    });
    input1.addEventListener('click', function () {
      input1.checked = true;
      input2.checked, input3.checked, input4.checked = false;
      obj.marginTop = 0 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'none');
      }
    });
    document.getElementById('classes').addEventListener('click', function () {
      obj.marginTop = -100 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'block');
      }
    });
    input2.addEventListener('click', function () {
      input2.checked = true;
      input1.checked, input3.checked, input4.checked = false;
      obj.marginTop = -100 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'block');
      }
    });
    document.getElementById('group').addEventListener('click', function () {
      obj.marginTop = -200 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'none');
      }
    });
    input3.addEventListener('click', function () {
      input3.checked = true;
      input2.checked, input1.checked, input4.checked = false;
      obj.marginTop = -200 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'none');
      }
    });
    document.getElementById('schedule').addEventListener('click', function () {
      obj.marginTop = -300 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'none');
      }
    });
    input4.addEventListener('click', function () {
      input4.checked = true;
      input2.checked, input3.checked, input1.checked = false;
      obj.marginTop = -300 + 'vh';
      if($('.btn-turma') != null){
        $('.btn-turma').css('display', 'none');
      }
    });
    document.addEventListener('keydown', function () {
      var tecla = event.keyCode;
  
      if (tecla == 37 || tecla == 38) {
        if (obj.marginTop == 0 + 'vh') {
          obj.marginTop = -300 + 'vh';
          input1.checked = false;
          input4.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'none');
          }
        } else if (obj.marginTop == -300 + 'vh') {
          obj.marginTop = -200 + 'vh';
          input4.checked = false;
          input3.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'none');
          }
        } else if (obj.marginTop == -200 + 'vh') {
          obj.marginTop = -100 + 'vh';
          input3.checked = false;
          input2.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'block');
          }
        } else if (obj.marginTop == -100 + 'vh') {
          obj.marginTop = 0 + 'vh';
          input2.checked = false;
          input1.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'none');
          }
        }
      }
  
      if (tecla == 39 || tecla == 40) {
        if (obj.marginTop == -300 + 'vh') {
          obj.marginTop = 0 + 'vh';
          input4.checked = false;
          input1.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'none');
          }
        } else if (obj.marginTop == -200 + 'vh') {
          obj.marginTop = -300 + 'vh';
          input3.checked = false;
          input4.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'none');
          }
        } else if (obj.marginTop == -100 + 'vh') {
          obj.marginTop = -200 + 'vh';
          input2.checked = false;
          input3.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'none');
          }
        } else if (obj.marginTop == 0 + 'vh') {
          obj.marginTop = -100 + 'vh';
          input1.checked = false;
          input2.checked = true;
          if($('.btn-turma') != null){
            $('.btn-turma').css('display', 'block');
          }
        }
      }
    });
  }
    
}

function gerenciar(){
  let arrays = document.querySelectorAll(".gerenciador > a");
  let grande = window.matchMedia("(min-width: 768px)");
  let medio =  window.matchMedia("(min-width: 576px) and (max-width: 767.68px)");
  let pequeno =  window.matchMedia("(min-width: 200px) and (max-width: 575.68px)");

  
  for(let i = 0; i < arrays.length; i++){ 
    arrays[i].addEventListener('click', (event) =>{
      
      if(grande.matches){
        if(event.target.className == 'multiplo1' || event.target.className == 'unico2'){
          if(event.target.className == 'unico2'){
            $('.unico2').attr("src", "./resources/assets/baseline_view_list_black_36dp.png");
            $('.multiplo1').attr("src", "./resources/assets/baseline_view_module_white_36dp.png");
            $('.card-turma').css('width', '50%');
          }else if(event.target.className == 'multiplo1'){
            $('.unico2').attr("src", "./resources/assets/baseline_view_list_white_36dp.png");
            $('.multiplo1').attr("src", "./resources/assets/baseline_view_module_black_36dp.png");
            $('.card-turma').css('width', '37%');
          }
        }
        else{
          if(event.target.className == 'unico4'){
            $('.unico4').attr("src", "./resources/assets/baseline_view_list_black_36dp.png");
            $('.multiplo3').attr("src", "./resources/assets/baseline_view_module_white_36dp.png");
            $('.card-grupo').css('width', '55%');
          }else if(event.target.className == 'multiplo3'){
            $('.unico4').attr("src", "./resources/assets/baseline_view_list_white_36dp.png");
            $('.multiplo3').attr("src", "./resources/assets/baseline_view_module_black_36dp.png");
            $('.card-grupo').css('width', '37%');
          }
        }
      }else if(medio.matches){
        if(event.target.className == 'multiplo1' || event.target.className == 'unico2'){
          if(event.target.className == 'unico2'){
            $('.unico2').attr("src", "./resources/assets/baseline_view_list_black_36dp.png");
            $('.multiplo1').attr("src", "./resources/assets/baseline_view_module_white_36dp.png");
            $('.card-turma').css('width', '60%');
          }else if(event.target.className == 'multiplo1'){
            $('.unico2').attr("src", "./resources/assets/baseline_view_list_white_36dp.png");
            $('.multiplo1').attr("src", "./resources/assets/baseline_view_module_black_36dp.png");
            $('.card-turma').css('width', '40%');
          }
        }
        else{
          if(event.target.className == 'unico4'){
            $('.unico4').attr("src", "./resources/assets/baseline_view_list_black_36dp.png");
            $('.multiplo3').attr("src", "./resources/assets/baseline_view_module_white_36dp.png");
            $('.card-grupo').css('width', '70%');
          }else if(event.target.className == 'multiplo3'){
            $('.unico4').attr("src", "./resources/assets/baseline_view_list_white_36dp.png");
            $('.multiplo3').attr("src", "./resources/assets/baseline_view_module_black_36dp.png");
            $('.card-grupo').css('width', '47%');
          }
        }
      }else if(pequeno.matches){
        if(event.target.className == 'multiplo1' || event.target.className == 'unico2'){
          if(event.target.className == 'unico2'){
            $('.unico2').attr("src", "./resources/assets/baseline_view_list_black_36dp.png");
            $('.multiplo1').attr("src", "./resources/assets/baseline_view_module_white_36dp.png");
            $('.card-turma').css('width', '75%');
          }else if(event.target.className == 'multiplo1'){
            $('.unico2').attr("src", "./resources/assets/baseline_view_list_white_36dp.png");
            $('.multiplo1').attr("src", "./resources/assets/baseline_view_module_black_36dp.png");
            $('.card-turma').css('width', '45%');
          }
        }
        else{
          if(event.target.className == 'unico4'){
            $('.unico4').attr("src", "./resources/assets/baseline_view_list_black_36dp.png");
            $('.multiplo3').attr("src", "./resources/assets/baseline_view_module_white_36dp.png");
            $('.card-grupo').css('width', '90%');
          }else if(event.target.className == 'multiplo3'){
            $('.unico4').attr("src", "./resources/assets/baseline_view_list_white_36dp.png");
            $('.multiplo3').attr("src", "./resources/assets/baseline_view_module_black_36dp.png");
            $('.card-grupo').css('width', '85%');
          }
        }
      }

      if(event.target.className == 'brilho1' || event.target.className == 'brilho2'){
        
        if(event.target.className == 'brilho2'){
          
          if(event.target.src == "http://localhost:8080/projcontrol/resources/assets/baseline_brightness_6_black_36dp.png"){
            
            $('#sass .brilho2').attr("src", "./resources/assets/baseline_brightness_6_white_36dp.png");
            $('#sass .card-header').css('background', 'white');
            $('#sass .card-header').css('color', 'black');
            $('#sass .card-text').css('color', 'white');
            $('#sass .card-body').css('color', 'white');
            $('#sass .card').css('background', '#2b2e39');

          }else{

            $('#sass .brilho2').attr("src", "./resources/assets/baseline_brightness_6_black_36dp.png");
            $('#sass .card-header').css('background', '#2b2e39');
            $('#sass .card-header').css('color', 'white');
            $('#sass .card-text').css('color', 'black');
            $('#sass .card-body').css('color', 'black');
            $('#sass .card').css('background', 'white');
          }
        }else{

          if(event.target.src == "http://localhost:8080/projcontrol/resources/assets/baseline_brightness_6_black_36dp.png"){
            
            $('#bootstrap .brilho1').attr("src", "./resources/assets/baseline_brightness_6_white_36dp.png");
            $('#bootstrap .card-header').css('background', 'white');
            $('#bootstrap .card-header').css('color', 'black');
            $('#bootstrap .card-text').css('color', 'white');
            $('#bootstrap .card-body').css('color', 'white');
            $('#bootstrap .card').css('background', '#2b2e39');

          }else{

            $('#bootstrap .brilho1').attr("src", "./resources/assets/baseline_brightness_6_black_36dp.png");
            $('#bootstrap .card-header').css('background', '#2b2e39');
            $('#bootstrap .card-header').css('color', 'white');
            $('#bootstrap .card-text').css('color', 'black');
            $('#bootstrap .card-body').css('color', 'black');
            $('#bootstrap .card').css('background', 'white');
          }
        }
      }  
    });
  }
}


export{animaAvatar,animaEscritaTexto,scrollDetect,animaDeslogar,gerenciar};