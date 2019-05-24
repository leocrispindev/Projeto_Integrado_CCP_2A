package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.AvaliacaoDAO;
import br.com.usjt.projcontrol.model.Avaliacao;

public class ServiceAvaliacao implements Serializable {
	private static final long serialVersionUID = 3159641701784067502L;
	
	private AvaliacaoDAO avaliacaoService;
	
	public ServiceAvaliacao() {
		avaliacaoService = new AvaliacaoDAO();
	}
	
	public ArrayList<Avaliacao> getAvaliacoes(String turma, String professor, String grupo) {
		int turma_id, professor_id, grupo_id;
		String filtros = "";
		
		
		turma_id = Integer.parseInt(turma);
		filtros = "WHERE Ta.turma_id = "+turma_id;
		
		if(professor != null && professor.length() > 0) {
			professor_id = Integer.parseInt(professor);
			filtros += " AND P.professor_id = "+professor_id;
		}
		
		if(grupo != null && grupo.length() > 0) {
			grupo_id = Integer.parseInt(grupo);
			filtros += " AND G.id = "+grupo_id;
		}
		
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<>();
		arrayAvaliacoes = avaliacaoService.getAvaliacoes(filtros);
		
		return arrayAvaliacoes;
	}
	
	public ArrayList<Avaliacao> getAvaliacaoByDate() {
		ArrayList<Avaliacao> ava = avaliacaoService.getAvaliacoesByDate();
		
		return ava;
	}
	
	public ArrayList<Avaliacao> getAvaliacaoDetalhes(int avaliacaoId){
		ArrayList<Avaliacao> avaliacoes = avaliacaoService.getAvaliacaoDetalhes(avaliacaoId);
		
		return avaliacoes;
	}
}
