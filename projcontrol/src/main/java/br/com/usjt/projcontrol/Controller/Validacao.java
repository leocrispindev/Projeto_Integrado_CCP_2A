package br.com.usjt.projcontrol.Controller;

public class Validacao {
	String [] mensagemSucesso = {"Sucesso!","Operação realizada com sucesso!","success"};
	String[] mensagemErro = {"Ops!","Preencha os dados corretamente.", "warning"};
	String[] mensagemErroSQL = {"Ops!","Este aluno possui vinculo com turmas.Não é possivel deleta-lo.", "info"};
	String[] mensagemErroSQLCatch = {"Ops!","Houve um problema com a operação. Contate o administrador do sistema.", "error"};
	String[] mensagemEmailInvalido = {"Ops!","Não encontramos nenhuma conta vinculada a este email .", "error"};
	
	public String[] getMensagemSucesso() {
		return this.mensagemSucesso;
	}
	
	public String[] getMensagemErro() {
		return this.mensagemErro;
	}
	
	public String[] getMensagemErroSQL() {
		return this.mensagemErroSQL;
	}
	
	public String[] getMensagemErroSQLCatch() {
		return this.mensagemErroSQLCatch;
	}
	
	public String[] getMensagemEmailInvalido() {
		return this.mensagemEmailInvalido;
	}
	
}
