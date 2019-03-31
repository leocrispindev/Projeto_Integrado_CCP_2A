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
    var botoes2 = $('.close-bar');

    // botoes2.on("click",()=>{
    //     $('.card-margin').remove();
    // })
    
}


export{deleteBtn,deletaOCard};