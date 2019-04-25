<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<link rel="stylesheet"
	href="./resources/node_modules/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./resources/css/dashBoardProfessor.css">
	<link rel="icon" href="./resources/assets/favicon.ico" type="image/x-icon">
	<title>Dashboard Professor</title>
</head>
<body>
	
	<!-- NAVBAR -->
	<nav class="navbar links">
		<label id="information" for="rd_nodejs">Informações</label>
		<label id="classes" for="rd_bootstrap">Turma</label>
		<label id="group" for="rd_sass">Grupo</label>
		<label id="schedule" for="rd_angular">Avaliações Semanais</label>
		<label id="label-custom" data-toggle="modal" data-target="#modal-alunos-crud" for="rd_ruby">Aluno</label>
	</nav>
	
	<!-- RADIOS RESPONSAVEIS PELA FUNCAO DA NAVBAR -->
	<div class="scroll">
		<form id="formDosRadio">
			<input type="radio" name="grupo" id="rd_nodejs" checked="true">
			<input type="radio" name="grupo" id="rd_bootstrap">
			<input type="radio" name="grupo" id="rd_sass">
			<input type="radio" name="grupo" id="rd_ruby">
			<input type="radio" name="grupo" id="rd_angular">
		</form>
		
		<section class="sections" id="scroll_control">
			
			<section class="bloco bloco-no-overflow" id="nodejs">
				<a data-target="#modalEscolha" data-toggle="modal" class="alterar-informacoes"><i
					class="fas fa-cog icone-gear" style="font-size: 50px; color: #fff;"></i>
				</a>
					<img src="./resources/assets/avatar2.png" id="avatar-usuario" class="avatar-usuario" alt="teste">
					<h1 class="titulo-informacoes">${professorDados.nome}</h1>
					<h1 class="corpo-informacoes">${professorDados.email}</h1>
					<h1 class="corpo-informacoes">5</h1>
					<form class="form-inline">
						<select class="periodo-letivo" id="inlineFormCustomSelectPref">
							<option disabled selected>Período Letivo</option>
							<option value="1">${PERIODO_LETIVO[1]}</option>
							<option value="2">${PERIODO_LETIVO[2]}</option>
							<option value="3">${PERIODO_LETIVO[3]}</option>
						</select>
					</form>
					<a title="Deslogar" href="entrada?acao=Logout" class="deslogar"><i class="deslogarFas fas fa-door-closed" style="font-size: 40px; color: #fff;"></i></a>
			</section>


				<section class="bloco bloco-no-overflow" id="bootstrap">
					<h1 class="titulo-informacoes titulo-top">Suas Turmas</h1>
					<div class="container-fluid">
						<table class="table table-dark">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Turma</th>
									<th scope="col">Tema</th>
									<th scope="col">Alunos</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row" id="botao-deletar" class="nao-deleta-linha"><a id="deletaLinhaTabela"><i class="fas fa-trash"></i></a></i></th>
									<td>CCP1B1-MCA3</td>
									<td>Chocolate</td>
									<td style="cursor:pointer;"><a data-toggle="modal" data-target="#modal-lista-alunos">Ver Alunos</a></td>
								</tr>
								<tr>
									<th scope="row" id="botao-deletar" class="nao-deleta-linha"><a id="deletaLinhaTabela"><i class="fas fa-trash"></i></a></th>
									<td>CCP1B1-MASDS</td>
									<td>Manga</td>
									<td style="cursor:pointer;"><a data-toggle="modal" data-target="#modal-lista-alunos">Ver Alunos</a></td>
								</tr>
								<tr>
									<th scope="row" id="botao-deletar" class="nao-deleta-linha"><a id="deletaLinhaTabela"><i class="fas fa-trash"></i></a></i></th>
									<td>CCP1B1-MDSS</td>
									<td>Arroz</td>
									<td style="cursor:pointer;"><a data-toggle="modal" data-target="#modal-lista-alunos">Ver Alunos</a></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="card text-dark bg-light mb-3 button-right btn-delete" style="max-width: 18rem;"></div>
					<div data-toggle="modal" data-target="#modal-crud-turma" class="card text-dark bg-light mb-3 button-right" style="max-width: 18rem;"></div>
					
				</section>
				<section class="bloco" id="sass">
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
					
					
				</section>
				
				<!-- <section class="bloco" id="ruby"></section> -->
				
				<section class="bloco bloco-no-overflow-y" id="angular">
					<h1 class="titulo-informacoes titulo-top">Avaliação Semanal</h1>
					
					<div class="checkboxes-all">
						<form class="form-inline">
							<select class="custom-select checkbox-filtro" id="inlineFormCustomSelectPref">
								<option disabled selected>Ano Letivo</option>
								<option value="1"></option>
								<option value="2"></option>
								<option value="3"></option>
							</select>
						</form>
						
						<form class="form-inline">
							<select class="custom-select checkbox-filtro" id="inlineFormCustomSelectPref">
								<option disabled selected>Semestre Letivo</option>
								<option value="1"></option>
								<option value="2"></option>
								<option value="3"></option>
							</select>
						</form>
						<form class="form-inline">
							<select class="custom-select checkbox-filtro" id="inlineFormCustomSelectPref">
								<option disabled selected>Turma</option>
								<option value="1"></option>
								<option value="2"></option>
								<option value="3"></option>
							</select>
						</form>
						<form class="form-inline">
							<select class="custom-select checkbox-filtro" id="inlineFormCustomSelectPref">
								<option disabled selected>Professor</option>
								<option value="1"></option>
								<option value="2"></option>
								<option value="3"></option>
							</select>
						</form>
						<form class="form-inline">
							<select class="custom-select checkbox-filtro" id="inlineFormCustomSelectPref">
								<option disabled selected>Grupo</option>
								<option value="1"></option>
								<option value="2"></option>
								<option value="3"></option>
							</select>
						</form>
					</div>
					
					<div class="container-fluid">
						<table class="table table-striped table-dark" id="tableAvaliacao">
							<thead>
								<tr>
									<th scope="col">Avaliação</th>
									<th scope="col">Nota</th>
									<th scope="col">Turma</th>
									<th scope="col">Grupo</th>
									<th scope="col">Professor</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
					</div>
					
				</section>
				
			</section>
		</section>
		
		<!-- Modal CRIAÇÃO DE TURMA-->
		<div class="modal fade" id="modal-crud-turma" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title alterar-informacoes-titulo" id="exampleModalLabel">Criar Turma</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="anoLetivo" class="col-form-label">Ano Letivo</label>
								<input type="number" class="form-control input-modal" value=${alunoDados.email} id="">
							</div>
							<div class="form-group">
								<label for="sigla" class="col-form-label">Sigla</label>
								<input type="text" class="form-control input-modal" id="">
							</div>
							<div class="form-group">
								<button data-toggle="modal" data-target="#vinculaAlunosTurma" type="button" class="btn btn-block btn-primary">Vincular Alunos a Turma <i class="fas fa-graduation-cap"></i></button>
							</div>
						</form>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-danger btn-alterar-info">Criar Turma</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Modal LISTA ALUNOS QUE PERTENCEM A TURMA-->
		<div class="modal fade" id="modal-lista-alunos" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalScrollableTitle">Lista de Alunos</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>João grilo</p>
						<p>Pedro cartilagem</p>
						<p>José dom bosco</p>
					</div>
					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn btn-primary">Ok</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- modal pra escolher TROCAR SENHA OU EMAIL-->
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
		
		
		<!-- Modal Carregar Alunos Para vincular a turma-->
		<div class="modal fade" id="vinculaAlunosTurma" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalScrollableTitle">Vincular Alunos a turma</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						
						<div class="contentAlunos">
							
							<div class="input-group mb-2 check-name-alunos">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input class="aluno-bug" type="checkbox">
									</div>
								</div>
								<input type="text" disabled class="form-control aluno-bug" value="${nomeDoAluno}">
							</div>
							<div class="input-group mb-2 check-name-alunos">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input class="aluno-bug" type="checkbox">
									</div>
								</div>
								<input type="text" disabled class="form-control aluno-bug" value="${nomeDoAluno}">
							</div>
							
						</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-primary">Salvar Alterações</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- MODAL CRUD ALUNOS -->
		<div class="modal fade" id="modal-alunos-crud" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dark modal-dialog-centered big-modal" role="document">
				<div id="modal-dark" class="modal-content modal-dark">
					<div class="modal-header">
							<div class="custom-control custom-switch">
								<input type="checkbox" class="custom-control-input light-mode" id="customSwitch1">
								<label class="custom-control-label light-mode-text" for="customSwitch1">Dark Mode On</label>
							</div>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body corpo-modal">	
						<form class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2 input-aluno-search" type="search" id="filtra-nomes" placeholder="Procurar Alunos" aria-label="Search">
							<div class="fluider">
								<select class="custom-select checkbox-filtro my-2 my-sm-0" id="possiveis-filtros">
									<option disabled selected>Filtrar</option>
									<option value="Ra">Ra</option>
									<option value="Nome">Nome</option>
								</select>
							</div>
						</form>
						<table class="table table-dark table-striped tabela-alunos" id="tableAlunos">
							<thead>
								<tr>
									<th scope="col">RA</th>
									<th scope="col">Nome</th>
									<th scope="col">Email</th>
									<th scope="col">#</th>
								</tr>
							</thead>
							<tbody>
								<tr id="aluno">
									<th id="raAluno" scope="row">81819595</th>
									<td id="nomeAluno" >Mark</td>
									<td>Otto</td>
									<td>
										<button type="button" id="deleta-aluno" class="btn btn-danger btn-sm">Deletar</button>
										<button data-toggle="modal" data-target=".informacoes-aluno-modal" type="button" class="btn btn-primary btn-sm">Ver Informações</button>
									</td>
								</tr>
								<tr id="aluno">
									<th id="raAluno" scope="row">81819599</th>
									<td id="nomeAluno">Jacob</td>
									<td>Thornton</td>
									<td>
										<button type="button" id="deleta-aluno" class="btn btn-danger btn-sm">Deletar</button>
										<button data-toggle="modal" data-target=".informacoes-aluno-modal" type="button" class="btn btn-primary btn-sm">Ver Informações</button>
									</td>
								</tr>
								<tr id="aluno">
									<th id="raAluno" scope="row">81810000</th>
									<td id="nomeAluno">Larry</td>
									<td>the Bird</td>
									<td>
										<button type="button" id="deleta-aluno" class="btn btn-danger btn-sm">Deletar</button>
										<button data-toggle="modal" data-target=".informacoes-aluno-modal" type="button" class="btn btn-primary btn-sm">Ver Informações</button>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<!-- MODAL SELECT DO ALUNO  -->			
			<div class="modal informacoes-aluno-modal" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered">
					<div id="mini-user" class="modal-content modal-dark conteudo-aluno">
						<img src="../resources/assets/estudante2.png" id="avatar-usuario" class="avatar-usuario mini-user" alt="Aluno">
						<h1 class="titulo-informacoes info-dark">${alunoDados.nome}</h1>
						<h1 class="corpo-informacoes info-dark">${alunoDados.email}</h1>
						<h1 class="corpo-informacoes info-dark">Grupo 3</h1>
						<h1 class="corpo-informacoes info-dark">3 Turmas</h1>
						<h1 class="corpo-informacoes info-dark">CCP123B-MCA CCPAS2-ASD CCPAS-2</h1>
						<button type="button" id="close-modal" class="btn btn-danger">Ok!</button>
					</div>
				</div>
			</div>
			
			
			<script src="./resources/node_modules/jquery/dist/jquery.min.js"></script>
			<script src="./resources/node_modules/sweetalert2/dist/sweetalert2.all.js"></script>
			<script src="./resources/js/TelaProfessor/dashBoardAdmin.js"></script>
			<script src="./resources/bundle.js"></script>
			<script defer src="./resources/js/all.min.js"></script>
		</body>
		</html>
		