<%@ page isErrorPage="true" import="java.io.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>500 Internal Server Error</title>

	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700" rel="stylesheet"> 
	<link type="text/css" rel="stylesheet" href="./resources/css/errorPages.css" />
</head>

<body>

	<div id="notfoundC">
		<div class="container-content">
			<img class="img" src="./resources/assets/erroricon.png" alt="">
			<h3 class="statusError">500 <br/></h3>
			<small class="subtitulo">OPS! PARECE QUE OCORREU UM PROBLEMA COM NOSSO SERVIDOR :(</small>
			<a title="Retornar a pagina principal" href="/projcontrol" class="deslogar"><i class="deslogarFas fas fa-door-closed" style="font-size: 40px; color: #fff;"></i></a>
		</div>
	</div>

	<script src="./resources/node_modules/jquery/dist/jquery.min.js"></script>
	<script defer src="./resources/js/all.min.js"></script>
	<script>
		$(".deslogar").on("mouseover",()=>{        
			$(".deslogarFas").removeClass('fa-door-closed');
			$(".deslogarFas").addClass('fa-door-open');
		});
	</script>
</body>

</html>
