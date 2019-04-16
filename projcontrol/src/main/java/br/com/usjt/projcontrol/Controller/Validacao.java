package br.com.usjt.projcontrol.Controller;

public class Validacao {
	String [] mensagemSucesso = {"Sucesso!","Operação realizada com sucesso!","success"};
	String[] mensagemErro = {"Erro!","Preencha os dados corretamente.", "error"};
	
	public String[] getMensagemSucesso() {
		return this.mensagemSucesso;
	}
	
	public String[] getMensagemErro() {
		return this.mensagemErro;
	}
}
