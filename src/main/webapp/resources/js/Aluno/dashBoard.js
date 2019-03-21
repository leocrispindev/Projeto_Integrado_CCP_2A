function ChamaLeftBar(){

    $('#btnLeftBar').on("click", ()=>{        

        if($('#leftBar').hasClass('leftBar')){

            $('#leftBar').removeClass('leftBar');
            $('#leftBar').addClass('leftBarAberta');

            $('.conteudo').attr("hidden", "true");

            $('.conteudo').removeAttr("hidden");

            $('.sessao-aluno').attr('hidden','true');

        }else if($('#leftBar').hasClass('leftBarAberta')){
            
            $('#leftBar').removeClass('leftBarAberta');
            $('#leftBar').addClass('leftBar');

            $('.conteudo').attr("hidden", "true");

            
            $('.sessao-aluno').removeAttr('hidden');

        }
    });


}


function alterarInformacoesConta(){
    
    $('#alteraInformacoesDaConta').on("click",()=>{
        

        $('.sessao-aluno').attr('hidden','true');
        $('.sessao-aluno2').removeAttr('hidden');

    });

    $('#voltaParaInformacoes').on("click",()=>{

        $('.sessao-aluno2').attr('hidden','true');
        $('.sessao-aluno').removeAttr('hidden');

    });
}


export{ChamaLeftBar,alterarInformacoesConta};