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
	
	public String[] setDelete(int id) {
		try {
			
			turmaD.deleteTurma(id);
			return this.getMensagemSucesso();
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
	
	public ArrayList<Turma> getListaTurmas() {
		ArrayList<Turma> turmas = turmaD.getAllTurmas();
		return turmas;
	}
	
	public ArrayList<Turma> getListaTurmasByPeriodo(Turma turma) {
		ArrayList<Turma> turmas = turmaD.getTurmasByPeriodo(turma);
		return turmas;
	}
	
	public ArrayList<Turma> getAnoLetivo() {
		ArrayList<Turma> periodo = turmaD.getAnoLetivo();
		return periodo;
	}
	
	public ArrayList<Turma> getAllPeriodosLetivos() {
		ArrayList<Turma> periodos = turmaD.getAllPeriodosLetivos();
		return periodos;
	}
	
	public String[] setVinculoAlunoTurma(String alunosIds, int turmaId) {
		try {
			
			String[] idsString = alunosIds.split(",");
			
			int[] ids = new int[idsString.length];
			
			for(int i = 0; i < ids.length; i++) {
				ids[i] = Integer.parseInt(idsString[i]);
			}
			
			turmaD.vinculaAlunoTurma(ids,turmaId);
			return this.getMensagemSucesso();
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
	
	public String[] setDesvincularAlunoTurma(int idAluno, int idTurma) {
		try {
			
			
			if(turmaD.desvinculaAlunoTurma(idAluno,idTurma)) {
				return this.getMensagemSucesso();
				
			}else {
				return this.getMensagemErroSQLCatch();
			}
			
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
