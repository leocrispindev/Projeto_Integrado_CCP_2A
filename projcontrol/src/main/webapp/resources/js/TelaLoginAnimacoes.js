function mudaParaTelaDeRegistro(){
    
    $("#fazerRegistro").on("click", (e)=>{
        $("#form-login").attr("hidden","true");
        
        $("#form-registro").removeAttr("hidden");

        $(".center-box").css("height","500px");
        
        $(".returnBtn").on("click",(e)=>{
            e.preventDefault();
            $("#form-login").removeAttr("hidden");
            $(".center-box").css("height","400px");
            $("#form-registro").attr("hidden","true");

            
            $(".professorAparece").attr("hidden","true");
            $(".alunoAparece").attr("hidden","true");
        });
    });
    
}

function capsLock(){
    document.addEventListener('keydown', function( event ) {
        var flag = event.getModifierState && event.getModifierState('CapsLock');
        if(flag){
            $('#inform-capslock').removeAttr('hidden','true');
        }else{
            $('#inform-capslock').attr('hidden','true');
        } 
        
        if(flag){
            $('#capslock-inform').removeAttr('hidden','true');
        }else{
            $('#capslock-inform').attr('hidden','true');
        } 
        
    });
}

function validaEmail(id){
    
    $(`${id}`).on("input",()=>{
        let email =  $(`${id}`).val();
        
        var regex = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/g);
        
        if(regex.test(email)){
            $(`${id}`).removeClass('is-invalid');
            $(`${id}`).addClass('is-valid');
            
        }else{
            $(`${id}`).removeClass('is-valid');
            $(`${id}`).addClass('is-invalid');
        }
        
    });
    
}

function validaSenha(id){
    
    $(`${id}`).on("input",()=>{
        
        var senha = $(`${id}`).val();
        
        var regex = new RegExp(/(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\W+)(?=^.{6,50}$).*$/g);
        if(regex.test(senha)){
            $(`${id}`).removeClass('is-invalid');
            $(`${id}`).addClass('is-valid');
            $('#senhaRequisitos').attr('hidden','true');
        }else{
            $(`${id}`).removeClass('is-valid');
            $(`${id}`).addClass('is-invalid');
            $('#senhaRequisitos').removeAttr('hidden');
            
        }
        
        if($('#userPasswordRegister').hasClass("is-invalid")){
            $('.senhaRequisitosRegistro').removeAttr('hidden');
            
        }else{
            $('#senhaRequisitosRegistro').attr('hidden','true');
        }
    });
    
}

function habilitaBotoes(id,buttonId){
    
    $(`${id}`).on("input",()=>{
        if($(`${id}`).hasClass('is-valid')){
            
            $(`${buttonId}`).removeAttr("disabled");
            
        }else if($(`${id}`).hasClass('is-invalid')){
            
            $(`${buttonId}`).attr("disabled",'true')
        }
    });
    
}

function textoRecuperarSenha(){
    $('#recuperarSenhaBtn').on("click",()=>{
        $('#infoEmail').removeAttr('hidden','true');
    });
}

function timeAlerta(){
    $("#fechaAlert").on("click",()=>{
        $(".alert").alert('close')
    });
}

function verificaCargo(){
    
    $('#imARegister').on("change",()=>{        
        
        console.log($('#imARegister').val());
        
        if($('#imARegister').val() == "professor"){
            
            $(".alunoAparece").attr("hidden","true");
            $(".professorAparece").removeAttr("hidden","true");
            
        }else if($('#imARegister').val() == "aluno"){

            $(".professorAparece").attr("hidden","true");
            $(".alunoAparece").removeAttr("hidden","true");

        }
    });
}

export{verificaCargo};
export{timeAlerta};
export{mudaParaTelaDeRegistro};
export{habilitaBotoes};
export{textoRecuperarSenha};
export{capsLock};
export{validaEmail};
export{validaSenha};