package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.AvaliacaoDAO;
import br.com.usjt.projcontrol.model.Avaliacao;
import br.com.usjt.projcontrol.model.Turma;

public class ServiceAvaliacao implements Serializable {
	private static final long serialVersionUID = 3159641701784067502L;
	
	private AvaliacaoDAO avaliacaoService;
	
	public ServiceAvaliacao() {
		avaliacaoService = new AvaliacaoDAO();
	}
	
	public ArrayList<Avaliacao> getAvaliacoes() {
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<>();
		arrayAvaliacoes = avaliacaoService.getAvaliacoes();
		
		return arrayAvaliacoes;
	}
	
	public ArrayList<Avaliacao> getAvaliacaoByDate() {
		ArrayList<Avaliacao> ava = avaliacaoService.getAvaliacoesByDate();
		
		return ava;
	}
}
