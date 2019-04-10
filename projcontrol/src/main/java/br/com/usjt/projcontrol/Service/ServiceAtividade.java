package br.com.usjt.projcontrol.Service;

import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.AtividadeDAO;
import br.com.usjt.projcontrol.model.Atividade;

public class ServiceAtividade {
	
	private AtividadeDAO dao;
	
	public ServiceAtividade() {
		dao = new AtividadeDAO();
	}
	
	public ArrayList<Atividade> getAtividades() {
		ArrayList<Atividade> atividades = new ArrayList<>();
		atividades = dao.getAtividades();
		
		return atividades;
	}

}
