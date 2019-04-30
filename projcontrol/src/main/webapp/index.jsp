<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="resources/node_modules/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="icon" href="resources/assets/favicon.ico" type="image/x-icon">
<title>Login</title>
</head>
<body>

	<main>

		<div class="center-box">

			<form id="form-login" action="entrada?acao=Login" method="POST">
				<div class="form-group">
					<small>N&atilde;o tem uma conta? <a id="fazerRegistro">Fa&ccedil;a
							seu registro</a>
					</small> <i hidden id="inform-capslock" title="CAPSLOCK LIGADO!"
						class="fas fa-lock  caps-lock-warn"></i> <br /> <label
						for="userEmail">Email</label> <input type="email"
						class="form-control" id="userEmail" name="usu_email" required>
				</div>
				<div class="form-group">
					<label for="userPassword">Senha</label> <i hidden
						id="senhaRequisitos"
						title="A senha &eacute; composta por:&#013;M&iacute;nimo 6 Caracteres&#013;Letra Mai&uacute;scula&#013;Letra Min&uacute;scula&#013; Caracter Especial&#013;N&uacute;mero"
						class="fas fa-info-circle password-warn"></i> <input
						type="password" class="form-control" id="userPassword"
						name="usu_senha" required>
				</div>
				<div class="form-group">
					<label for="imA">Eu sou um:</label> <select
						class="form-control form-control-md" id="imA" data-offset="10,20" name="usuario_acesso" required>
						<option selected id="disabledOp" disabled value="default">Selecione</option>
						<option>Aluno</option>
						<option>Administrador</option>
					</select>
				</div>
				<small class="forgot-passowrd"><a href="#"
					data-toggle="modal" data-target="#esqueciMinhaSenha">Esqueceu
						sua Senha?</a></small> <br />
				<button disabled type="submit"
					class="btn btn-primary btn-lg btn-block loginBtn">Login</button>
			</form>

			<!-- FORMULARIO DE REGISTRO -->
			<form class="form-registro" id="form-registro" hidden>
				<div class="form-group">
					<label for="imARegister">Eu serei um:</label><i hidden
						id="capslock-inform" title="CAPSLOCK LIGADO!"
						class="fas fa-lock caps-lock-warn"></i> <select
						class="form-control form-control-md select-control"
						id="imARegister" required>
						<option selected id="disabledOp" disabled value="default">Selecione</option>
						<option value="aluno">Aluno</option>
						<option value="professor">Professor</option>
					</select>
				</div>

				<div class="input-group alunoAparece" id="nomeAlunoRegistro" hidden>
					<div class="input-group-prepend">
						<button class="btn btn-outline-dark" type="button" disabled
							id="button-addon1">Nome e RA</button>
					</div>
					<input type="text" class="form-control" id="userNomeRegister"
						required> <input type="text" aria-label="Ra"
						id="userRaRegister" class="form-control">
				</div>
				<div class="input-group professorAparece" id="nomeProfessorRegistro"
					hidden>
					<div class="input-group-prepend">
						<button class="btn btn-outline-dark" type="button" disabled
							id="button-addon1">Nome e Matricula</button>
					</div>
					<input type="text" class="form-control" id="userNomeRegister"
						required> <input type="text" aria-label="Matricula"
						id="userMatriculaRegister" class="form-control">
				</div>
				<br />
				<div class="form-group">
					<label for="userEmailRegister">Email</label> <input type="email"
						class="form-control" id="userEmailRegister" required>
				</div>
				<div class="form-group">
					<label for="userPasswordRegister">Senha</label> <i hidden
						id="senhaRequisitosRegistro"
						title="A senha &eacute; composta por:&#013;M&iacute;nimo 6 Caracteres&#013;Letra Mai&uacute;scula&#013;Letra Min&uacute;scula&#013; Caracter Especial&#013;N&uacute;mero"
						class="fas fa-info-circle password-warn senhaRequisitosRegistro"></i>
					<input type="password" class="form-control userPasswordRegister"
						id="userPasswordRegister" required>
				</div>
				<br />
				<button type="button"
					class="btn btn-secondary btn-xl btn-block returnBtn">Retornar</button>
				<button type="button" data-toggle="collapse"
					data-target="#successWarn" disabled type="submit"
					class="btn btn-primary btn-xl btn-block registerBtn" onclick="setCadastroAluno()">Registrar
				</button>
			</form>
		</div>

	
	<!-- MODAL ESQUECI MINHA SENHA -->
	<div class="modal fade" id="esqueciMinhaSenha" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content modal-animation">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Esqueceu a
						senha?</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="POST" action="entrada?acao=GetEmailTrocaSenha">
						<div class="form-group">
							<label for="recuperarEmail">Endereço de E-mail</label>
							<input type="email" name="emailRecuperarSenha" class="form-control" id="recuperarEmail" 
							aria-describedby="emailHelp"> 
							<small id="infoEmail"
								class="text-success" hidden>Enviamos as informações
								de senha para o respectivo email!
							</small>
							<br/>
							<button disabled type="submit" class="btn btn-primary"
							id="recuperarSenhaBtn">Recuperar Senha</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	</main>
	<script src="./resources/node_modules/jquery/dist/jquery.min.js"></script>
	<script src="resources/js/TelaLogin/telaLogin.js"></script>
	<script src="resources/bundle.js"></script>
	<script src="./resources/node_modules/sweetalert2/dist/sweetalert2.all.js"></script>
	<script defer src="resources/js/all.min.js"></script>
</body>
</html>