package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Avaliacao;

class AvaliacaoDAOTest {
	
	private AvaliacaoDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new AvaliacaoDAO();
	}

	@Test
	void testGetAvaliacoesComFiltro() {
		String filtros = " ";
		ArrayList<Avaliacao> lista = dao.getAvaliacoes(filtros);
		
		assertEquals(1, lista.get(0).getAvaliacaoId());
		assertEquals("CCP1AN-MCA", lista.get(0).getTurma().getSigla());
		assertEquals("Professor Keity", lista.get(0).getGrupo().getProfessor().getNome());
		
		filtros = "WHERE Ta.turma_id = 1 ";
		lista = dao.getAvaliacoes(filtros);
		
		assertEquals(1, lista.get(0).getAvaliacaoId());
		assertEquals("CCP1AN-MCA", lista.get(0).getTurma().getSigla());
		assertEquals("Professor Keity", lista.get(0).getGrupo().getProfessor().getNome());
		
		filtros += " AND P.professor_id = 1 ";
		lista = dao.getAvaliacoes(filtros);
		
		assertEquals(1, lista.get(0).getAvaliacaoId());
		assertEquals("CCP1AN-MCA", lista.get(0).getTurma().getSigla());
		assertEquals("Professor Keity", lista.get(0).getGrupo().getProfessor().getNome());
		
		filtros += " AND G.id = 1 ";
		lista = dao.getAvaliacoes(filtros);
		
		assertEquals(1, lista.get(0).getAvaliacaoId());
		assertEquals("CCP1AN-MCA", lista.get(0).getTurma().getSigla());
		assertEquals("Professor Keity", lista.get(0).getGrupo().getProfessor().getNome());
	}
	
	@Test
	void testgetAvaliacoesByDate() {
		ArrayList<Avaliacao> listaByDate = dao.getAvaliacoesByDate();
		
		assertEquals(2018, listaByDate.get(0).getTurma().getAnoLetivo());
		assertEquals(1, listaByDate.get(0).getTurma().getSemestreLetivo());
	}
	
}
