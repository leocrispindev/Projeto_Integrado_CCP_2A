package br.com.usjt.projcontrol.Service;

import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.GrupoDAO;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Turma;

public class ServiceGrupo {
	
	private GrupoDAO dao;
	
	public ServiceGrupo() {
		dao = new GrupoDAO();
	}
	
	public ArrayList<Grupo> getListaGruposByAlunoId(int id) {
		ArrayList<Grupo> gruposAlunoId = new ArrayList<>();
		gruposAlunoId = dao.getGruposByAlunoID(id);
		
		return gruposAlunoId;
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
