package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Turma;

class GrupoDAOTest {

	private GrupoDAO dao;
	private ArrayList<Grupo> lista;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new GrupoDAO();
		lista = new ArrayList<Grupo>();
	}

	@Test
	void testGruposPorAlunoId() {
		Aluno aluno = new Aluno();
		aluno.setId(11);
		
		lista = dao.getGruposByAluno(aluno, 2019, 1);
		
		assertEquals(11, lista.get(0).getNumero_grupo());
		assertEquals("Grupo11", lista.get(0).getNome());
		assertEquals("Professor Antonio", lista.get(0).getProfessor().getNome());
	}
	
	@Test
	void testTodosOsGrupos() {
		lista = dao.getGrupos();
		
		assertEquals(1, lista.get(0).getNumero_grupo());
		assertEquals("Grupo1", lista.get(0).getNome());
		assertEquals("Professor Keity", lista.get(0).getProfessor().getNome());
		
		assertEquals(10, lista.get(9).getNumero_grupo());
		assertEquals("Grupo10", lista.get(9).getNome());
		assertEquals("Professor Vicente", lista.get(9).getProfessor().getNome());
	}
	
	@Test
	void testGruposByTurmaId() {
		Turma turma = new Turma();
		turma.setCodigoIdentificador(4);
		lista = dao.getGruposByTurmaId(turma);
		
		assertEquals(16, lista.get(0).getId());
		assertEquals("Grupo16", lista.get(0).getNome());
	}
	
	@Test
	void testGruposComFiltro() {
		String filtros = " ";
		
		lista = dao.getGruposByTurmaProfessor(filtros);
		assertEquals(1, lista.get(0).getId());
		assertEquals(20, lista.get(lista.size() - 1).getId());
		
		filtros = "WHERE t.id = 1 ";
		lista = dao.getGruposByTurmaProfessor(filtros);
		assertEquals(1, lista.get(0).getId());
		assertEquals(5, lista.get(lista.size() - 1).getId());
		
		filtros += " AND p.professor_id = 1 ";
		lista = dao.getGruposByTurmaProfessor(filtros);
		assertEquals(1, lista.get(0).getId());
		assertEquals(5, lista.get(lista.size() - 1).getId());
		
		filtros = " WHERE p.professor_id = 2 ";
		lista = dao.getGruposByTurmaProfessor(filtros);
		assertEquals(6, lista.get(0).getId());
		assertEquals(10, lista.get(lista.size() - 1).getId());
		
		filtros = " WHERE t.id = 3 ";
		lista = dao.getGruposByTurmaProfessor(filtros);
		assertEquals(11, lista.get(0).getId());
		assertEquals(15, lista.get(lista.size() - 1).getId());
	}
}
