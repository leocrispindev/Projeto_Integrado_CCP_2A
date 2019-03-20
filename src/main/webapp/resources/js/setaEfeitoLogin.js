function efeito(){

    $('.seta').on('click', () =>{
        $('.top-bar').addClass('top-bar-after');

        $('.form-size').addClass('form-size-after');

        disableBotaoProsseguir();

        enablePassword();

        if($('.top-bar').height() >= 80){
            $('.top-bar').removeClass('top-bar-after');
            
            $('.form-size').removeClass('form-size-after');
        }else{

        }
    });


    
}

function disableBotaoProsseguir(){

    let inputLogin = $('#login');

    $('#btnLogin').attr('disabled','true');

    inputLogin.on("input",()=>{
        var caracteres = inputLogin.val();

        if(caracteres === ""){

            $('#btnLogin').attr('disabled','true');
            
        }else{
            
            $('#btnLogin').removeAttr('disabled','true');
        }
    });

}

function enablePassword(){
    
    $('#btnLogin').on("click", (event) =>{
        event.preventDefault();
        
        $('.loginLabel').attr('hidden','true');
        $('#login').attr('hidden','true');

        $('#loginLabel').removeAttr('hidden');
        $('#password').removeAttr('hidden');
        $('#esqueciMinhaSenha').removeAttr('hidden');

        $('.passwordLabel').removeAttr("hidden");

        $('#btnLogin').text('Logar');
        $('#btnRetornar').removeAttr('hidden');

        $('#btnRetornar').on("click",(event) =>{
            event.preventDefault();

            $('.loginLabel').removeAttr('hidden','true');
            $('#login').removeAttr('hidden','true');  

            $("#passwordLabel").attr("hidden",'true');
            $('.passwordLabel').attr("hidden",'true');
            $('#password').attr("hidden",'true');

            $("#esqueciMinhaSenha").attr("hidden",'true');


            $('#btnLogin').text('Prosseguir');
            $('#btnRetornar').attr("hidden",true);
        });
        
    });

}


export{efeito};
export{disableBotaoProsseguir};
export{enablePassword};