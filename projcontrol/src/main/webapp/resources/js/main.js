global.jQuery = require('jquery');
import $ from 'jquery';
import 'bootstrap';
// PELO AMOR DE DEUS NAO MEXA NISSO OBRIGADO

import {capsLock, validaEmail, validaSenha, textoRecuperarSenha, 
    habilitaBotoes, mudaParaTelaDeRegistro, timeAlerta, verificaCargo} from './TelaLogin/TelaLoginAnimacoes';

capsLock();
validaEmail("#userEmail");
validaSenha("#userPassword");

validaEmail("#recuperarEmail");

validaEmail("#userEmailRegister");
validaSenha("#userPasswordRegister");


textoRecuperarSenha();
habilitaBotoes("#recuperarEmail","#recuperarSenhaBtn");
habilitaBotoes("#userPassword",".loginBtn");

habilitaBotoes("#userPasswordRegister",".registerBtn");
mudaParaTelaDeRegistro();
verificaCargo();

timeAlerta();

import {animaAvatar, animaEscritaTexto} from './TelaAluno/TelaAlunoAnimacoes';

animaAvatar();

animaEscritaTexto('.titulo-informacoes');

validaEmail('#EmailAlterado');
validaSenha('#SenhaAlterada');
