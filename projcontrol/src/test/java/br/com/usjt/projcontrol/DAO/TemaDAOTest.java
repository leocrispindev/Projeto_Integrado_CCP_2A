package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Tema;

class TemaDAOTest {
	
	private TemaDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new TemaDAO();
	}

	@Test
	void testGetTemas() {
		ArrayList<Tema> lista = dao.getTema();
		
		assertEquals(1, lista.get(0).getTema_id());
		assertEquals("Projeto Interdisciplicar 1", lista.get(0).getTitulo());
		assertEquals(4, lista.get(3).getTema_id());
		assertEquals("Projeto Integrado 2", lista.get(3).getTitulo());
	}

}
