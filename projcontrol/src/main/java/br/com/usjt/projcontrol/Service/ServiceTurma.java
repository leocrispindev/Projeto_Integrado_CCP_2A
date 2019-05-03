package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Controller.Validacao;
import br.com.usjt.projcontrol.DAO.TurmaDAO;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Turma;

public class ServiceTurma extends Validacao implements Serializable {
	private static final long serialVersionUID = -9191323271768963923L;
	
	TurmaDAO turmaD = null;
	String mensagem = "";
	
	public ServiceTurma() {
		turmaD = new TurmaDAO();
	}
	
	public String[] setCadastro(Turma turma) {
		
		try {
			turmaD.cadastrarTurma(turma);
			return this.getMensagemSucesso();
		} catch(Exception e) {
			return this.getMensagemErro();
		}
	}
	
	public String setUpdate(Turma turma) {
		try {
			
			turmaD.updateTurma(turma);
			mensagem = "Operação Efetuada com Sucesso";
			
		}catch(Exception e) {
			mensagem = "Houve um erro no processo. Contate o Administrador do sistema.";
		}
		
		return mensagem;
	}
	
	public String[] setDelete(Turma turma) {
		try {
			
			turmaD.deleteTurma(turma);
			return this.getMensagemSucesso();
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
	
	public ArrayList<Turma> getListaTurmas() {
		ArrayList<Turma> turmas = turmaD.getTurmas();
		return turmas;
	}
	
	public ArrayList<Turma> getListaTurmasByPeriodo(Turma turma) {
		ArrayList<Turma> turmas = turmaD.getTurmasByPeriodo(turma);
		return turmas;
	}
	
	public ArrayList<Turma> getPeriodoLetivo() {
		ArrayList<Turma> periodo = turmaD.getPeriodoLetivo();
		return periodo;
	}
	
	public ArrayList<Turma> getPeriodoLetivoByAlunoId(Aluno aluno) {
		ArrayList<Turma> periodo = turmaD.getPeriodoLetivoByAlunoId(aluno);
		return periodo;
	}

}
