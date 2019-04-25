<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<link rel="stylesheet" href="./resources/node_modules/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./resources/css/dashBoardAluno.css">
	<link rel="icon" href="./resources/assets/favicon.ico" type="image/x-icon">
	<title>Dashboard Aluno</title>
</head>

<body>

	<nav class="navbar links">
		<label id="information" for="rd_nodejs">Informações</label>
		<label id="classes" for="rd_bootstrap">Turma</label>
		<label id="group" for="rd_sass">Grupo</label>
		<label id="schedule" for="rd_angular">Cronograma</label>
	</nav>

	<div class="scroll">
		<form id="formDosRadio">
			<input type="radio" name="grupo" id="rd_nodejs" checked="true">
			<input type="radio" name="grupo" id="rd_bootstrap">
			<input type="radio" name="grupo" id="rd_sass">
			<input type="radio" name="grupo" id="rd_angular">
		</form>

		<section class="sections" id="scroll_control">

			
			<section class="bloco" id="nodejs">
				<a data-target="#modalEscolha" data-toggle="modal" class="alterar-informacoes"><i
				class="fas fa-cog icone-gear" style="font-size: 50px; color: #fff;"></i></a>
				<img src="./resources/assets/estudante2.png" id="avatar-usuario" class="avatar-usuario" alt="teste">
				<h1 class="titulo-informacoes">${alunoDados.nome}</h1>
				<h1 class="corpo-informacoes">${alunoDados.email}</h1>
				<h1 class="corpo-informacoes">Grupo 3</h1>
				<form class="form-inline">
					<select class="periodo-letivo" id="inlineFormCustomSelectPref">
						<option disabled selected>Período Letivo</option>
						<option value="1">${PERIODO_LETIVO[1]}</option>
						<option value="2">${PERIODO_LETIVO[2]}</option>
						<option value="3">${PERIODO_LETIVO[3]}</option>
					</select>
				</form>
				<a href="entrada?acao=Logout" title="Deslogar" class="deslogar"><i class="deslogarFas fas fa-door-closed" style="font-size: 40px; color: #fff;"></i></a>

			</section>


			<section class="bloco bloco-no-overflow" id="bootstrap">
				<h1 class="titulo-informacoes titulo-top">Suas Turmas</h1>

				<div class="card-box">

					<c:forEach var="turma" items="${turmasDados}">
						<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
							<div class="card-header">${turma.getSigla()}</div>
							<div class="card-body">
								<h5 class="card-title">${turma.getTurmaTema().getTitulo()}</h5>
								<p class="card-text">${turma.getTurmaTema().getIntroducao()}</p>
							</div>
						</div>

					</c:forEach>


				</div>

				<!-- <div class="card text-dark bg-light mb-3 button-right" style="max-width: 18rem;"></div> -->

			</section>
			
			<section class="bloco " id="sass">
				<h1 class="titulo-informacoes titulo-top grupo-titulo">Grupo</h1>

				<div class="card text-dark bg-light mb-3 card-margin card-grupo" style="max-width: 18rem;">
					<div class="card-header">Numero do Grupo </div>
					<div class="card-body">
						<h5 class="card-title">Keit Yamamoto </h5>
						<p class="card-text">Japa <small style="font-weight:bold;">NOTA</small></p>
						<p class="card-text">Fake Japa <small style="font-weight:bold;">NOTA</small></p>
						<p class="card-text">CssGuy <small style="font-weight:bold;">NOTA</small></p>
						<p class="card-text">Springmen <small style="font-weight:bold;">NOTA</small></p>
						<p class="card-text">Leozao <small style="font-weight:bold;">NOTA</small></p>
					</div>
				</div>

				<!-- <div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
						<div class="card-header">${numeroDoGrupo}</div>
						<div class="card-body card-grupo">
							<h5 class="card-title">${$teste}</h5>
							c:foreach Pelos alunos que o grupo possui
							<p class="card-text">${aluno} <small style="font-weight:bold;">${aluno.nota}</small></p>
							fim do foreach
						</div>
					</div> -->

			</section>
			<section class="bloco bloco-no-overflow-y" id="angular">
				<h1 class="titulo-informacoes titulo-top">Cronograma</h1>

				<div class="container-fluid">
					<table class="table table-striped table-dark">
						<thead>
							<tr>
								<th scope="col">Atividade</th>
								<th scope="col">Descrição da Atividade</th>
								<th scope="col">Data de Postagem</th>
								<th scope="col">Data de Entrega</th>
								<th scope="col">Enviar Atividade</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th id="numeroAtividade" scope="row">1</th>
								<td id="descAtividade">Entrega de Telas</td>
								<td id="dataDePostagem">12/01/2019</td>
								<td id="dataDeEntrega">12/07/2019</td>
								<td><button data-toggle="modal" data-target="#modalEntrega" id="btnEnviarAtividades"
										type="button" class="btn btn-danger">Enviar Atividade</button></td>
							</tr>
							<tr>
								<th id="numeroAtividade" scope="row">2</th>
								<td id="descAtividade">Entrega do DAO</td>
								<td id="dataDePostagem">12/01/2019</td>
								<td id="dataDeEntrega">24/08/2019</td>
								<td><button data-toggle="modal" data-target="#modalEntrega" id="btnEnviarAtividades"
										type="button" class="btn btn-danger">Enviar Atividade</button></td>
							</tr>
							<!-- <tr>
								<th scope="row">2 tem que somar 1 na row sempre</th>
								<td>${one}</td>
								<td>${two}</td>
								<td>${three}</td>
							</tr> -->
						</tbody>
					</table>
				</div>
			</section>
		</section>


		<!-- modal pra escolher -->
		<div class="modal fade" id="modalEscolha" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title alterar-informacoes-titulo" id="exampleModalCenterTitle">Escolha uma
							opção</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<button id="troca-email" type="button" class="btn btn-lg btn-danger btn-block"
							data-dismiss="modal">Alterar Email</button>
						<br />
						<button id="troca-senha" type="button" class="btn btn-lg btn-primary btn-block"
						data-dismiss="modal" >Alterar Senha </button>
					</div>
				</div>
			</div>
		</div>

		<!-- MODAL ENVIO ATIVIDADE ALUNO -->
		<div class="modal fade" id="modalEntrega" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Enviar Atividades</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p id="recebeInformacoes"></p>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="customFileLang" lang="es">
							<label class="custom-file-label" for="customFileLang">Selecionar Arquivo</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
						<button type="button" class="btn btn-danger">Enviar Atividade</button>
					</div>
				</div>
			</div>
		</div>

		<script src="./resources/node_modules/jquery/dist/jquery.min.js"></script>
		<script src="./resources/node_modules/sweetalert2/dist/sweetalert2.all.js"></script>
		<script src="./resources/js/TelaAluno/dashBoardAluno.js"></script>
		<script src="./resources/bundle.js"></script>
		<script defer src="./resources/js/all.min.js"></script>
</body>

</html>