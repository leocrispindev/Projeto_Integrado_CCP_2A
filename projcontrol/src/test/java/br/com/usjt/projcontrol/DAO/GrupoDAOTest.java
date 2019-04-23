package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Grupo;

class GrupoDAOTest {

	private GrupoDAO dao;
	private ArrayList<Grupo> lista;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new GrupoDAO();
		lista = new ArrayList<Grupo>();
	}

	@Test
	void testArrayDeGruposPorAlunoId() {
		int alunoId = 11;
		lista = dao.getGruposByAlunoID(alunoId);
		
		//O método não retorna o nome do aluno
		//"Martin Bernardo Carvalho"
		assertEquals(1, lista.get(0).getNumero_grupo());
		assertEquals("Grupo1", lista.get(0).getNome());
		assertEquals(1, lista.get(0).getProfessor().getId());
		assertEquals("Professor Keity", lista.get(0).getProfessor().getNome());
	}
	
	@Test
	void testArrayTodosOsGrupos() {
		lista = dao.getGrupos();
		
		assertEquals(1, lista.get(0).getNumero_grupo());
		assertEquals("Grupo1", lista.get(0).getNome());
		assertEquals("Professor Keity", lista.get(0).getProfessor().getNome());
		
		assertEquals(10, lista.get(9).getNumero_grupo());
		assertEquals("Grupo10", lista.get(9).getNome());
		assertEquals("Professor Danilo", lista.get(9).getProfessor().getNome());
	}
	
	@Test
	void testGrupoId() {
		int id = 20;
		int ultimoGrupoId = dao.getGrupoId();
		
		assertEquals(id, ultimoGrupoId);
	}

}
