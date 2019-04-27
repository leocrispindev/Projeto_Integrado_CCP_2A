package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Controller.Validacao;
import br.com.usjt.projcontrol.DAO.AlunoDAO;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Turma;
import br.com.usjt.projcontrol.model.Usuario;

public class ServiceAluno extends Validacao implements Serializable{
	AlunoDAO usuarioD = null;
	
	public ServiceAluno() {
		usuarioD = new AlunoDAO();
	}
	
	public Aluno setCredencaisLogin(Aluno aluno) {
		return usuarioD.loginAluno(aluno);
	}
	
	public String[] setCadastro(Aluno aluno) {
		try {
			
			usuarioD.cadastrarAluno(aluno);
			return this.getMensagemSucesso();
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
	
	/*public String setUpdate(Aluno aluno) {
		try {
			
			usuarioD.updateAluno(aluno);
			mensagem = "Operação Efetuada com Sucesso";
			
		}catch(Exception e) {
			mensagem[0] = "Erro";
			mensagem[1] = "Os campos preenchidos possuem valores diferentes.";
			mensagem[2] = "error";
		}
		
		return mensagem;
	}*/
	
	public String[] setDelete(int id) {
		try {
			
			if(usuarioD.deleteAluno(id)) {
				return this.getMensagemSucesso();
			}else {
				return this.getMensagemErroSQL();
			}
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
		
	}
	
	
	public ArrayList<Turma> getTurmasByAluno(int id) {
		ArrayList<Turma> arrayTurmas = new ArrayList<Turma>();
		
		arrayTurmas = usuarioD.getTurmasByAlunoID(id);
		
		return arrayTurmas;
	}
	
	public ArrayList<Aluno> getListaAllAlunos(Aluno aluno) {
		ArrayList<Aluno> arrayAlunos = usuarioD.getAllAlunos(aluno);
		return arrayAlunos;
	}
	
	
	
}
