package br.com.usjt.projcontrol.Controller;

public class Validacao {
	String [] mensagemSucesso = {"Sucesso!","Operação realizada com sucesso!","success"};
	String[] mensagemErro = {"Ops!","Preencha os dados corretamente.", "warning"};
	String[] mensagemErroSQL = {"Ops!","Este aluno possui vinculo com turmas.Não é possivel deleta-lo.", "info"};
	String[] mensagemErroSQLCatch = {"Ops!","Houve um problema com a operação. Contate o administrador do sistema.", "error"};
	String[] mensagemErroDeleteTurma = {"Ops!","Houve um problema com a operação. A turma possui alunos vinculados, remova-os para prosseguir com a operação.", "error"};
	
	public String[] getMensagemErroDeleteTurma() {
		return mensagemErroDeleteTurma;
	}

	public void setMensagemErroDeleteTurma(String[] mensagemErroDeleteTurma) {
		this.mensagemErroDeleteTurma = mensagemErroDeleteTurma;
	}

	String[] mensagemEmailInvalido = {"Ops!","Não encontramos nenhuma conta vinculada a este email .", "error"};
	String[] mensagemDuplicidadeSigla = {"Ops!","Sigla já existente na aplicação.", "warning"};
	
	public String[] getMensagemDuplicidadeSigla() {
		return mensagemDuplicidadeSigla;
	}

	public void setMensagemDuplicidadeSigla(String[] mensagemDuplicidadeSigla) {
		this.mensagemDuplicidadeSigla = mensagemDuplicidadeSigla;
	}

	public void setMensagemSucesso(String[] mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	public void setMensagemErro(String[] mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public void setMensagemErroSQL(String[] mensagemErroSQL) {
		this.mensagemErroSQL = mensagemErroSQL;
	}

	public void setMensagemErroSQLCatch(String[] mensagemErroSQLCatch) {
		this.mensagemErroSQLCatch = mensagemErroSQLCatch;
	}

	public void setMensagemEmailInvalido(String[] mensagemEmailInvalido) {
		this.mensagemEmailInvalido = mensagemEmailInvalido;
	}

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
