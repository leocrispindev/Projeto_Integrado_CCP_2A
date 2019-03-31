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
	
	<nav class="navbar links">
		<label id="label-custom" for="rd_nodejs">Informações</label>
		<label id="label-custom" for="rd_bootstrap">Turma</label>
		<label id="label-custom" for="rd_sass">Grupo</label>
		<label id="label-custom" for="rd_ruby">Tema</label>
		<label id="label-custom" for="rd_angular">Cronograma</label>
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
			<section class="bloco" id="nodejs">
				<a data-toggle="modal" data-target="#modal-trocar-senha" class="alterar-informacoes"><i class="fas fa-cog icone-gear" style="font-size: 50px; color: #fff;"></i></a>
				<img src="./resources/assets/avatar2.png" id="avatar-usuario" class="avatar-usuario" alt="teste">
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
				<a class="deslogar"><i class="fas fa-sign-out-alt" style="font-size: 40px; color: #fff;"></i></a>
				
				<!-- COMO INSERIR DINAMICAMENTE -->
				
				<!-- <h1 class="titulo-informacoes">${nome}</h1>
					<h1 class="corpo-informacoes">${email}</h1>
					<h1 class="corpo-informacoes">${grupoQuePertence}</h1>
					<form class="form-inline">
						FAZ UM :FOREACH PRA PEGAR OS PERIODOS LETIVOS DO ALUNO E COLOCAR AI NO SELECT
						<select class="periodo-letivo" id="inlineFormCustomSelectPref">
							<option disabled selected>Período Letivo</option>
							<option value="1">${PERIODO_LETIVO[1]}</option>
							<option value="2">${PERIODO_LETIVO[2]}</option>
							<option value="3">${PERIODO_LETIVO[3]}</option>
						</select>
					</form> -->
					
				</section>
				<section class="bloco bloco-no-overflow" id="bootstrap">
					<h1 class="titulo-informacoes titulo-top">Suas Turmas</h1>
					
					<div class="card-box">
						<div onclick="deleta('.card-margin')" class="card text-dark bg-light mb-3 turmas card-margin" style="max-width: 18rem;">
							<div class="card-header">CCPS1DS-DSS <a><small class="botao-fechar"></small></a></div>
							<div class="card-body">
								<h5 class="card-title">Professor: Teste</h5>
								<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</div>
						
						<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
							<div class="card-header">CCP1D1-C14 <a><small class="botao-fechar" ></small></a></div>
							<div class="card-body">
								<h5 class="card-title">Professor: Teste</h5>
								<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</div>
						
						
						<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
							<div class="card-header">CCPNE-32A <a><small class="botao-fechar"></small></a></div>
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
								<p class="card-text">${$teste}</p>
							</div>
						</div> -->
						<!-- fecha foreach -->
						
					</div>
					
					<div class="card text-dark bg-light mb-3 button-right btn-delete" style="max-width: 18rem;"></div>
					<div data-toggle="modal" data-target="#modal-crud-turma" class="card text-dark bg-light mb-3 button-right" style="max-width: 18rem;"></div>
					
				</section>
				<section class="bloco" id="sass">
					<h1 class="titulo-informacoes titulo-top">Grupo</h1>
					
					<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
						<div class="card-header">Numero do Grupo </div>
						<div class="card-body card-grupo">
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
				<section class="bloco" id="ruby">
					<h1 class="titulo-informacoes titulo-top">Tema</h1>
					
					<div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
						<div class="card-header">Titulo</div>
						<div class="card-body card-grupo">
							<h5 class="card-title">data de Cadastro</h5>
							<p class="card-text">Introducao</p>
							<p class="card-text">Requisitos</p>
						</div>
					</div>
					
					<!-- <div class="card text-dark bg-light mb-3 card-margin" style="max-width: 18rem;">
						<div class="card-header">${titulo}</div>
						<div class="card-body card-grupo">
							<h5 class="card-title">${data_de_cadastro}</h5>
							<p class="card-text">${introducao}</p>
							<p class="card-text">${requisitos}</p>
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
									<td><button data-toggle="modal" data-target="#modalEntrega" id="btnEnviarAtividades" type="button" class="btn btn-danger">Enviar Atividade</button></td>
								</tr>
								<tr>
									<th id="numeroAtividade" scope="row">2</th>
									<td id="descAtividade">Entrega do DAO</td>
									<td id="dataDePostagem">12/01/2019</td>
									<td id="dataDeEntrega">24/08/2019</td>
									<td><button data-toggle="modal" data-target="#modalEntrega" id="btnEnviarAtividades" type="button" class="btn btn-danger">Enviar Atividade</button></td>
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
							<h5 class="modal-title alterar-informacoes-titulo" id="exampleModalLabel">Alterar Informações</h5>
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
							</form>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Nome</th>
										<th scope="col">#</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td>Mark</td>
										<td><input type="checkbox" class="checkbox-aluno"></td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td>Jacob</td>
										<td><input type="checkbox" class="checkbox-aluno"></td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td>Larry</td>
										<td><input type="checkbox" class="checkbox-aluno"></td>
									</tr>
									<tr>
										<th scope="row">4</th>
										<td>Larry</td>
										<td><input type="checkbox" class="checkbox-aluno"></td>
									</tr>
									<tr>
										<th scope="row">5</th>
										<td>Larry</td>
										<td><input type="checkbox" class="checkbox-aluno"></td>
									</tr>
									<tr>
										<th scope="row">6</th>
										<td>Larry</td>
										<td><input type="checkbox" class="checkbox-aluno"></td>
									</tr>
								</tbody>
							</table>
							
							<nav aria-label="Navegação de página exemplo">
								<ul class="pagination paginacao-alunos">
									<li class="page-item">
										<a class="page-link" href="#" aria-label="Anterior">
											<span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Anterior</span>
										</a>
									</li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item">
										<a class="page-link" href="#" aria-label="Próximo">
											<span aria-hidden="true">&raquo;</span>
											<span class="sr-only">Próximo</span>
										</a>
									</li>
								</ul>
							</nav>
							<!-- COMO USAR
							VOCÊ VAI CARREGAR ALUNOS DE ACORDO COM A PÁGINA CLICADA, A CADA CLIQUE NÁ VAI CARREGAR
						ALUNOS DIFERETENS -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
							<button type="button" class="btn btn-danger btn-alterar-info">Alterar Informações</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			
			<script src="./resources/bundle.js"></script>
			<script defer src="./resources/js/all.min.js"></script>
		</body>
		</html>