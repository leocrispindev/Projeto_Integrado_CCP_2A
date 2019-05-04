package br.com.usjt.projcontrol.Service;

import java.util.ArrayList;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import br.com.usjt.projcontrol.DAO.GrupoDAO;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Turma;

public class ServiceGrupo {
	
	private GrupoDAO dao;
	
	public ServiceGrupo() {
		dao = new GrupoDAO();
	}
	
	public ArrayList<Grupo> getGruposByAluno(Aluno aluno, int ano, int semestre) {
		ArrayList<Grupo> grupo = new ArrayList<>();
		grupo = dao.getGruposByAluno(aluno, ano, semestre);
		
		return grupo;
	}
	
	public ArrayList<Grupo> getListaGrupos() {
		ArrayList<Grupo> grupos = new ArrayList<>();
		grupos = dao.getGrupos();
		
		return grupos;
	}
	
	public ArrayList<Grupo> getListaGruposByTurmaId(Turma turma) {
		ArrayList<Grupo> grupos = new ArrayList<>();
		grupos = dao.getGruposByTurmaId(turma);
		
		return grupos;
	}
}
