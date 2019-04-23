<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  -->
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> -->

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<link rel="stylesheet"
	href="../resources/node_modules/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="../resources/css/dashBoardProfessor.css">
	<link rel="icon" href="../resources/assets/favicon.ico" type="image/x-icon">
	<title>Dashboard Professor</title>
</head>
<body>
	
	<nav class="navbar links">
		<label id="label-custom" for="rd_nodejs">Informações</label>
		<label id="label-custom" for="rd_bootstrap">Turma</label>
		<label id="label-custom" for="rd_sass">Grupo</label>
		<label id="label-custom" for="rd_angular">Avaliações Semanais</label>
		<label id="label-custom" data-toggle="modal" data-target="#modal-alunos-crud" for="rd_ruby">Aluno</label>
	</nav>
	
	<div class="scroll">
		<form id="formDosRadio">
			<input type="radio" name="grupo" id="rd_nodejs" checked="true">
			<input type="radio" name="grupo" id="rd_bootstrap">
			<input type="radio" name="grupo" id="rd_sass">
			<input type="radio" name="grupo" id="rd_ruby">
			<input type="radio" name="grupo" id="rd_angular">
		</form>
		
		<section class="sections">
			
			<section class="bloco bloco-no-overflow" id="nodejs">
				<a data-target="#modalEscolha" data-toggle="modal" class="alterar-informacoes"><i
					class="fas fa-cog icone-gear" style="font-size: 50px; color: #fff;"></i></a>
					<img src="../resources/assets/avatar2.png" id="avatar-usuario" class="avatar-usuario" alt="teste">
					<h1 class="titulo-informacoes">${professorDados.nome}</h1>
					<h1 class="corpo-informacoes">${professorDados.email}</h1>
					<h1 class="corpo-informacoes">${professorDados.gruposQuantidade}</h1>
					<form class="form-inline">
						<select class="periodo-letivo" id="inlineFormCustomSelectPref">
							<option disabled selected>Período Letivo</option>
							<option value="1">${PERIODO_LETIVO[1]}</option>
							<option value="2">${PERIODO_LETIVO[2]}</option>
							<option value="3">${PERIODO_LETIVO[3]}</option>
						</select>
					</form>
					<a title="Deslogar" class="deslogar"><i class="deslogarFas fas fa-door-closed" style="font-size: 40px; color: #fff;"></i></a>
					
					
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
										<input type="email" class="form-control input-modal input-alterar-informacoes" value=${alunoDados.email} id="EmailAlterado">
									</div>
									<div class="form-group">
										<i hidden id="senhaRequisitos" title="A senha é composta por:&#013;Minimo 6 Caracteres&#013;Letra Maiuscula&#013;Letra Minuscula&#013; Caracter Especial&#013;Numero"
										class="fas fa-info-circle password-warn"></i>
										<label for="SenhaAlterada" class="col-form-label">Nova Senha:</label>
										<input type="password" class="form-control input-modal input-alterar-informacoes" id="SenhaAlterada">
									</div>
									<div class="form-group">
										<i hidden id="senhaRequisitos" title="A senha é composta por:&#013;Minimo 6 Caracteres&#013;Letra Maiuscula&#013;Letra Minuscula&#013; Caracter Especial&#013;Numero"
										class="fas fa-info-circle password-warn"></i>
										<label for="SenhaAlterada" class="col-form-label">Confirmar senha:</label>
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
				
				<!-- Modal -->
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
				
				<!-- Modal LISTA ALUNOS vinculados a turma-->
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
				
				
				<!-- MODAL ALUNOS -->
				<div class="modal fade" id="modal-alunos-crud" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered big-modal" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalCenterTitle">Alunos</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form class="form-inline my-2 my-lg-0">
									<input class="form-control mr-sm-2 input-aluno-search" type="search" placeholder="Search" aria-label="Search">
									<button class="btn btn-danger my-2 my-sm-0" type="submit">Search</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				
				
				
				<script src="../resources/node_modules/jquery/dist/jquery.min.js"></script>
				<script src="../resources/node_modules/sweetalert2/dist/sweetalert2.all.js"></script>
				<script src="../resources/js/TelaAluno/dashBoardAluno.js"></script>
				<script src="../resources/bundle.js"></script>
				<script defer src="../resources/js/all.min.js"></script>
			</body>
			</html>