<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<link rel="stylesheet"
	href="resources/node_modules/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/dashBoardAluno.css">
	<link rel="icon" href="resources/assets/favicon.ico" type="image/x-icon">
	<title>Dashboard Aluno</title>
</head>
<body>
	
	<nav class="navbar links">
		<label for="rd_nodejs">Informações</label>
		<label for="rd_bootstrap">Turma</label>
		<label for="rd_sass">Grupo</label>
		<label for="rd_ruby">Tema</label>
		<label for="rd_angular">Cronograma</label>
	</nav>
	
	<div class="scroll">
		<input type="radio" name="grupo" id="rd_nodejs" checked="true">
		<input type="radio" name="grupo" id="rd_bootstrap">
		<input type="radio" name="grupo" id="rd_sass">
		<input type="radio" name="grupo" id="rd_ruby">
		<input type="radio" name="grupo" id="rd_angular">
		
		<section class="sections">
			<section class="bloco" id="nodejs">
				<a class="alterar-informacoes"><i class="fas fa-cog icone-gear" style="font-size: 50px; color: #fff;"></i></a>
				<img src="./resources/assets/avatar.png" id="avatar-usuario" class="avatar-usuario" alt="teste">
				<h1 class="titulo-informacoes">Luke Skywalker</h1>
				<h1 class="corpo-informacoes">luke@skywalker.com</h1>
				<h1 class="corpo-informacoes">Aluno</h1>
				<h1 class="corpo-informacoes">CCP1BNC-SS1</h1>
				<h1 class="corpo-informacoes">Grupo 7</h1>
			</section>
			<section class="bloco" id="bootstrap">

			</section>
			<section class="bloco" id="sass"></section>
			<section class="bloco" id="ruby"></section>
			<section class="bloco" id="angular"></section>
		</section>
		
		<script src="resources/bundle.js"></script>
		<script defer src="resources/js/all.min.js"></script>
	</body>
	</html>