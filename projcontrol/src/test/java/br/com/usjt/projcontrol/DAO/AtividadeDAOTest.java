package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Atividade;

class AtividadeDAOTest {
	
	private AtividadeDAO dao;
	private ArrayList<Atividade> lista;

	@BeforeEach
	void setUp() throws Exception {
		dao = new AtividadeDAO();
		lista = new ArrayList<Atividade>();
	}

	@Test
	void testArrayDeAtividades() {
		lista = dao.getAtividades();
		assertEquals(1, lista.get(0).getAtividadeId());
		assertEquals("Apresentação do Projeto", lista.get(0).getDescricao());
		assertEquals("2019-02-22", lista.get(0).getDataInicio().toString());
		assertEquals("Notebook do Leo", lista.get(0).getTema().getRequisitos());
		
		assertEquals(2, lista.get(1).getAtividadeId());
		assertEquals("Implementação de 3 classes (do model)", lista.get(1).getDescricao());
		assertEquals("2019-03-01", lista.get(1).getDataInicio().toString());
		assertEquals("Material das Aulas", lista.get(1).getTema().getRequisitos());
	}
	
	@Test
	void testAtividadeId() {
		int id = 14;
		int ultimoIdInserido = dao.getAtividadeId();
		
		assertEquals(id, ultimoIdInserido);
	}

}
