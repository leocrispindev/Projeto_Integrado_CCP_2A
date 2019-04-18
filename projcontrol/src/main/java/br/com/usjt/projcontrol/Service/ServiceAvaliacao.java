package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.AvaliacaoDAO;
import br.com.usjt.projcontrol.model.Avaliacao;

public class ServiceAvaliacao implements Serializable {
	private static final long serialVersionUID = 3159641701784067502L;
	
	private AvaliacaoDAO dao;
	
	public ServiceAvaliacao() {
		dao = new AvaliacaoDAO();
	}
	
	public ArrayList<Avaliacao> getAvaliacoes() {
		ArrayList<Avaliacao> lista = new ArrayList<>();
		lista = dao.getAvaliacoes();
		
		return lista;
	}
}
