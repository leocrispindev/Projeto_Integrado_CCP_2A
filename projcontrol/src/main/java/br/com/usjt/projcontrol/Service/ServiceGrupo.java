package br.com.usjt.projcontrol.Service;

import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.GrupoDAO;
import br.com.usjt.projcontrol.model.Grupo;

public class ServiceGrupo {
	
	GrupoDAO dao;
	
	public ServiceGrupo() {
		dao = new GrupoDAO();
	}
	
	public ArrayList<Grupo> getListaGrupos() {
		ArrayList<Grupo> grupos = new ArrayList<>();
		grupos = dao.getGrupos();
		
		return grupos;
	}

}
