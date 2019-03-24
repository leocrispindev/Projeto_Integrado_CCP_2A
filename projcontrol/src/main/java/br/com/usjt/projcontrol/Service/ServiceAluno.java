package br.com.usjt.projcontrol.Service;

import java.io.Serializable;

import br.com.usjt.projcontrol.DAO.AlunoDAO;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Usuario;

public class ServiceAluno implements Serializable{
	AlunoDAO usuarioD = null;
	String mensagem = "";
	
	public ServiceAluno() {
		usuarioD = new AlunoDAO();
	}
	
	public Aluno setCredencaisLogin(Aluno aluno) {
		return usuarioD.loginAluno(aluno);
	}
	
	public String setCadastro(Aluno aluno) {
		try {
			
			usuarioD.cadastrarAluno(aluno);
			mensagem = "Operação Efetuada com Sucesso";
			
		}catch(Exception e) {
			mensagem = "Houve um erro no processo. Contate o Administrador do sistema.";
		}
		
		return mensagem;
	}
	
	public String setUpdate(Aluno aluno) {
		try {
			
			usuarioD.updateAluno(aluno);
			mensagem = "Operação Efetuada com Sucesso";
			
		}catch(Exception e) {
			mensagem = "Houve um erro no processo. Contate o Administrador do sistema.";
		}
		
		return mensagem;
	}
	
	public String setDelete(int id) {
		try {
			
			usuarioD.deleteAluno(id);
			mensagem = "Operação Efetuada com Sucesso";
			
		}catch(Exception e) {
			mensagem = "Houve um erro no processo. Contate o Administrador do sistema.";
		}
		
		return mensagem;
	}
	
	
	
	
	
	
	
	
	
	
	
}
