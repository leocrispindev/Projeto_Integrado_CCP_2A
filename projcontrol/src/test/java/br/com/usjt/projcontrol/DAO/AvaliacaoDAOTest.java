package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Avaliacao;

class AvaliacaoDAOTest {
	
	private AvaliacaoDAO dao;
	private ArrayList<Avaliacao> lista;

	@BeforeEach
	void setUp() throws Exception {
		dao = new AvaliacaoDAO();
		lista = new ArrayList<Avaliacao>();
	}

	@Test
	void testArrayDeAvaliacoes() {
		lista = dao.getAvaliacoes();
		
		assertEquals(1, lista.get(0).getAvaliacaoId());
		assertEquals(10.00, lista.get(0).getNota());
		assertEquals("2019-02-22", lista.get(0).getDataAvaliacao().toString());
		
		assertEquals(2, lista.get(1).getAvaliacaoId());
		assertEquals(9.50, lista.get(1).getNota());
		assertEquals("2019-02-22", lista.get(1).getDataAvaliacao().toString());
	}
	
	@Test
	void testAvaliacaoId() {
		int id = 28;
		int ultimoIdAvaliacao = dao.getAvaliacaoId();
		
		assertEquals(id, ultimoIdAvaliacao);
	}

}
