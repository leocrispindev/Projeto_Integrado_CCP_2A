package br.com.usjt.projcontrol.Controller;

public class Validacao {
	String [] mensagemSucesso = {"Sucesso!","Operação realizada com sucesso!","success"};
	String[] mensagemErro = {"Ops!","Preencha os dados corretamente.", "warning"};
	String[] mensagemErroSQL = {"Ops!","Este aluno possui vinculo com turmas.Não é possivel deleta-lo.", "info"};
	
	public String[] getMensagemSucesso() {
		return this.mensagemSucesso;
	}
	
	public String[] getMensagemErro() {
		return this.mensagemErro;
	}
	
	public String[] getMensagemErroSQL() {
		return this.mensagemErroSQL;
	}
}
