function animacaoBotaoAdicionar(){
    

    $('#fixed-menu').on("click",()=>{
        $('#fixed-menu').removeClass('fixed-menu');
        $('#fixed-menu').addClass('fixed-menu-center');
        
    });
    

}

export{animacaoBotaoAdicionar};