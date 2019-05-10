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
	
	public ArrayList<Grupo> getGruposByProfTurma(String professor, String turma) {
		int turmaId, profId;
		String filtros = "";
		
		if(isValid(turma) && isValid(professor)) {
			turmaId = Integer.parseInt(turma);
			filtros = "WHERE t.id = " + turmaId;
			profId = Integer.parseInt(professor);
			filtros += " AND p.professor_id = " + profId;
		} else if(isValid(turma)) {
			turmaId = Integer.parseInt(turma);
			filtros = " WHERE t.id = " + turmaId;
		} else if(isValid(professor)) {
			profId = Integer.parseInt(professor);
			filtros = " WHERE p.professor_id = " + profId;
		} 
		
		ArrayList<Grupo> gruposFiltrados = dao.getGruposByTurmaProfessor(filtros);
		return gruposFiltrados;
	}
	
    private boolean isNullOrEmpty(String s) {
        return (s == null || s.equals(""));
    }
	
	private boolean isValid(String filtro) {
		if(filtro.length() <= 0)
			return false;
		if(filtro.equals(" "))
			return false;
		if(isNullOrEmpty(filtro))
			return false;
		if(filtro.equals("Turma"))
			return false;
		if(filtro.equals("Professor"))
			return false;
			
		return true;
	}
}
