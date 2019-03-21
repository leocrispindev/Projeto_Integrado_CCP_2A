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
    <link rel="stylesheet" href="resources/css/dashBoard.css">
    <link rel="icon" href="resources/assets/favicon.ico" type="image/x-icon">
    <title>Dashboard Aluno</title>
</head>
<body>
    
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#26262b;">
        
        
        <ul class="navbar-nav">
            <li class="nav-item navbar-toggler btnLeftBar" id="btnLeftBar" data-toggle="collapse" data-target="#leftbar" >
                <a class="nav-link" href="#"><i class="fas fa-align-justify"></i></a>
            </li>
            <li class="nav-item" style="font-size: 25px;">
                <a class="nav-link" href="#"><i class="fas fa-sign-out-alt sign-out-btn"></i></a>
            </li>
        </ul>
        <div class="collapse navbar-collapse" id="navbarNav">
            
        </div>
        
        <a class="navbar-brand" href="#">
            <img src="./resources/assets/logousjt.png" class="logoNavbar" width="130" height="40" class="d-inline-block align-top" alt="Logo Universidade">
        </a>
    </nav>
    
    <!-- SESSAO INFORMACOES DO ALUNO -->
    
    <main>
        <div class="sessao-aluno">
            <a id="alteraInformacoesDaConta">
                <i class="configBtn fas fa-cog" style="font-size:20px;"></i>
            </a>
            <i class="fas fa-user" style="font-size:50px;"></i>
            <h1>Alvin O Esquilo</h1>
            <p>Email</p>
            <p>Aluno</p>
            <p>Turma</p>
            <p>Grupo</p>
            <label for="periodoLetivo">Periodo Letivo:</label>
            <select class="form-control custom-select">
                <option disabled selected>Selecione</option>
                <option>opcao 1</option>
                <option>opcao 2</option>
                <option>opcao 3</option>
            </select>
        </div>
    </main>
    
    <main>
        <div class="sessao-aluno2" hidden>
            <a id="voltaParaInformacoes">
                <i class="configBtn fas fa-cog" style="font-size:20px;"></i>
            </a>
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
                    <small id="emailHelp" class="form-text text-muted">Digite seu novo Email</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Senha</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                    <small id="emailHelp" class="form-text text-muted">Digite sua nova senha</small>
                </div>
                <button type="submit" class="btn btn-outline-primary">Trocar Informações</button>
            </form>
        </div>
    </main>

    
    <!-- LEFT BAR -->
    
    <div class="leftBar" id="leftBar">
        <div class="conteudo" hidden>
            <h6 class="title-side-bar">Geral</h6>
            <button type="button" class="btn-left-bar btn btn-outline-primary btn-lg btn-block">Turma <i class="fas fa-users"></i></button>
            <button type="button" class="btn-left-bar btn btn-outline-danger btn-lg btn-block">Grupo <i class="fas fa-user-friends"></i></button>
            <button type="button" class="btn-left-bar btn btn-outline-success btn-lg btn-block">Tema <i class="fas fa-clipboard-list"></i></button>
        </div>
    </div>

    <div class="container">
            <div class="box">
                <div class="box-information">
                    <h1>Quantidade de grupos</h1>
                    <i class="fas fa-user" style="font-size:60px;"></i>
                    <h1>13</h1>
                </div>
                <div class="box-information">
                    <h1>Quantidade de projetos</h1>       
                    <i class="fas fa-user" style="font-size:60px;"></i>     
                    <h1>13</h1>    
                </div>
                <div class="box-information">
                    <h1>Quantidade de alunos na turma</h1>
                    <i class="fas fa-user" style="font-size:60px;"></i>
                    <h1>13</h1>
                </div>
                <div class="box-information">
                    <h1>Quantidade de turmas</h1>
                    <i class="fas fa-user" style="font-size:60px;"></i>
                    <h1>13</h1>
                </div>
            </div>
        </div>
    
    
    
    
    <script src="resources/bundle.js"></script>
    <script defer src="resources/js/all.min.js"></script>
</body>
</html>