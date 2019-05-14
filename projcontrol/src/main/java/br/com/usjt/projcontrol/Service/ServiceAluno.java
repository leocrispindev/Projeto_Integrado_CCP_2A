package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Controller.Validacao;
import br.com.usjt.projcontrol.DAO.AlunoDAO;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Atividade;
import br.com.usjt.projcontrol.model.Avaliacao;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Turma;

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
	
	public ArrayList<Aluno> getListaAllAlunos() {
		ArrayList<Aluno> arrayAlunos = usuarioD.getAllAlunos();
		return arrayAlunos;
	}
	
	public Aluno getDadosAlunoById(int id) {
		Aluno aluno = new Aluno();
		
		aluno = usuarioD.getDadosAlunoById(id);
		aluno.setTurmas(this.getTurmasByAluno(aluno.getId()));
		
		return aluno;
	}
	
	public ArrayList<Grupo> getGruposByAluno(int id) {
		ArrayList<Grupo> arrayGrupos = new ArrayList<Grupo>();
		arrayGrupos = usuarioD.getGruposByAlunoId(id);
		return arrayGrupos;
	}
	
	public ArrayList<Atividade> getAtividadeByAluno(int id) {
		ArrayList<Atividade> arrayAtividades = new ArrayList<Atividade>();
		arrayAtividades = usuarioD.getAtividadeByAlunoID(id);
		return arrayAtividades;
	}
	
	public ArrayList<Atividade> getAtividadeByAlunoPeriodoLetivo(int id, int ano, int semestre) {
		ArrayList<Atividade> arrayAtividades = new ArrayList<Atividade>();
		arrayAtividades = usuarioD.getAtividadeByAlunoIdPeriodoLetivo(id, ano, semestre);
		return arrayAtividades;
	}
	
	public ArrayList<Aluno> getIntegrantesDoGrupo(int id) {
		ArrayList<Aluno> integrantes = new ArrayList<Aluno>();
		integrantes = usuarioD.getAlunosByGrupoId(id);
		return integrantes;
	}
	
	public ArrayList<Turma> getPeriodoLetivoByAlunoId(Aluno aluno) {
		ArrayList<Turma> periodo = usuarioD.getPeriodoLetivoByAlunoId(aluno);
		return periodo;
	}
	
	public ArrayList<Turma> getTurmasByAlunoPeriodoLetivo(int id, int ano, int semestre){
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		turmas = usuarioD.getTurmasByAlunoIdPeriodoLetivo(id, ano, semestre);
		return turmas;
	}
	
	public ArrayList<Aluno> getAlunosVinculo(Turma turma) {
		ArrayList<Aluno> arrayAlunos = usuarioD.getAlunosVinculo(turma);
		return arrayAlunos;
	}

}
