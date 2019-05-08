<%@ page isErrorPage="true" import="java.io.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>404 Page Not Found</title>

	<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai|Stylish" rel="stylesheet"> 
	<link type="text/css" rel="stylesheet" href="./resources/css/errorPages.css" />
</head>

<body>

	<div id="notfoundC">
		<h1 class="title">5<i class="fas fa-cog engrena"></i>0</h1>
		<h6 class="subtitulo">PARECE QUE OCORREU ALGUM <br/> PROBLEMA COM NOSSO SERVIDOR ;(</h6>
		<a href="/projcontrol" title="Retornar a pagina principal" class="deslogar">
			<i class="deslogarFas fas fa-door-closed" style="font-size: 40px; color: #fff;"></i>
		</a>
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
