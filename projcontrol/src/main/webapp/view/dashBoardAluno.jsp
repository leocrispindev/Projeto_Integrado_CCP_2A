<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<link rel="stylesheet"
	href="../resources/node_modules/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="../resources/css/dashBoardAluno.css">
	<link rel="icon" href="../resources/assets/favicon.ico" type="image/x-icon">
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
				<a data-toggle="modal" data-target="#modal-trocar-senha" class="alterar-informacoes"><i class="fas fa-cog icone-gear" style="font-size: 50px; color: #fff;"></i></a>
				<img src="../resources/assets/avatar.png" id="avatar-usuario" class="avatar-usuario" alt="teste">
				<h1 class="titulo-informacoes">Luke Skywalker</h1>
				<h1 class="corpo-informacoes">luke@skywalker.com</h1>
				<h1 class="corpo-informacoes">Aluno</h1>
				<h1 class="corpo-informacoes">Grupo 7</h1>
				<form class="form-inline">
					<select class="periodo-letivo" id="inlineFormCustomSelectPref">
						<option disabled selected>Período Letivo</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</form>
				
				<!-- COMO INSERIR DINAMICAMENTE -->
				
				<!-- <h1 class="titulo-informacoes">${nome}</h1>
					<h1 class="corpo-informacoes">${email}</h1>
					<h1 class="corpo-informacoes">${grupoQuePertence}</h1>
					<form class="form-inline">
						FAZ UM :FOREACH PRA PEGAR OS PERIODOS LETIVOS DO ALUNO E COLOCAR AI 
						<select class="periodo-letivo" id="inlineFormCustomSelectPref">
							<option disabled selected>Período Letivo</option>
							<option value="1">${PERIODO LETIVO 1}</option>
							<option value="2">${PERIODO LETIVO 3}</option>
							<option value="3">${PERIODO LETIVO 2}</option>
						</select>
					</form> -->
					
				</section>
				<section class="bloco bloco-no-overflow" id="bootstrap">
					<h1 class="titulo-informacoes titulo-top">Suas Turmas</h1>
					
					<div class="card-box">
						<div class="card text-dark bg-light mb-3 turmas card-margin" style="max-width: 18rem;">
							<div class="card-header">CCPS1DS-DSS</div>
							<div class="card-body">
								<h5 class="card-title">Professor: Teste</h5>
								<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</div>
						
						<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
							<div class="card-header">CCP1D1-C14</div>
							<div class="card-body">
								<h5 class="card-title">Professor: Teste</h5>
								<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</div>
						
						
						<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
							<div class="card-header">CCPNE-32A</div>
							<div class="card-body">
								<h5 class="card-title">Professor: Teste</h5>
								<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</div>
						
						<!-- c:foreach -->
						<!-- <div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
							<div class="card-header">${TURMA}</div>
							<div class="card-body">
								<h5 class="card-title">${PROFESSOR}</h5>
								<p class="card-text">${Tema c:foreach{atividade}}</p>
							</div>
						</div> -->
						<!-- fecha foreach -->
						
					</div>
					
					<!-- <div class="card text-dark bg-light mb-3 button-right" style="max-width: 18rem;"></div> -->
					
				</section>
				<section class="bloco" id="sass">
					<div class="grupo-aluno">
						
						<div class="aluno">
							<i class="fas fa-male" style="color:#fff; font-size:80px;"></i>
							<h6>Japa</h6>
						</div>
						<div class="aluno">
							<i class="fas fa-male" style="color:#fff; font-size:80px;"></i>
							<h6>Fake Japa</h6>
						</div>
						<div class="aluno">
							<i class="fas fa-male" style="color:#fff; font-size:80px;"></i>
							<h6>cssguy</h6>
						</div>
						<div class="aluno">
							<i class="fas fa-male" style="color:#fff; font-size:80px;"></i>
							<h6>Springmen</h6>
						</div>
						<div class="aluno">
							<i class="fas fa-male" style="color:#fff; font-size:80px;"></i>
							<h6>PhpDude</h6>
						</div>
						
					</div>

					<div class="aluno">
						<i class="fas fa-male" style="color:#fff; font-size:80px;"></i>
						<h6>Keitola</h6>
					</div>
				</section>
				<section class="bloco" id="ruby"></section>
				<section class="bloco" id="angular"></section>
			</section>
			
			<!-- Modal -->
			<div class="modal fade" id="modal-trocar-senha" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title alterar-informacoes-titulo" id="exampleModalLabel">Alterar Informações</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form-group">
									<label for="EmailAlterado" class="col-form-label">Novo Email:</label>
									<input type="email" class="form-control input-modal input-alterar-informacoes" id="EmailAlterado">
								</div>
								<div class="form-group">
									<i hidden id="senhaRequisitos" title="A senha é composta por:&#013;Minimo 6 Caracteres&#013;Letra Maiuscula&#013;Letra Minuscula&#013; Caracter Especial&#013;Numero"
									class="fas fa-info-circle password-warn"></i>
									<label for="SenhaAlterada" class="col-form-label">Nova Senha:</label>
									<input type="password" class="form-control input-modal input-alterar-informacoes" id="SenhaAlterada">
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
							<button type="button" class="btn btn-danger btn-alterar-info">Alterar Informações</button>
						</div>
					</div>
				</div>
			</div>
			
			<script src="../resources/bundle.js"></script>
			<script defer src="../resources/js/all.min.js"></script>
		</body>
		</html>