package br.com.usjt.projcontrol.DAO;



import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Tema;
import br.com.usjt.projcontrol.model.Turma;

class TurmaDAOTest {
	
	private Turma turma;
	private TurmaDAO turmaDao;

	@BeforeEach
	void setUp() throws Exception {
		turma = new Turma();
		turmaDao = new TurmaDAO();
	}
	
	@Test
	void testGetAllTurmas() {
		ArrayList<Turma> lista = turmaDao.getAllTurmas();
		
		assertEquals(1, lista.get(0).getCodigoIdentificador());
		assertEquals("CCP1AN-MCA", lista.get(0).getSigla());
		assertEquals(4, lista.get(3).getCodigoIdentificador());
		assertEquals("CCP2AN-MCA", lista.get(3).getSigla());
	}
	
	@Test
	void testTurmasByPeriodo() {
		turma.setAnoLetivo(2019);
		turma.setSemestreLetivo(1);
		ArrayList<Turma> lista = turmaDao.getTurmasByPeriodo(turma);
		
		assertEquals(3, lista.get(0).getCodigoIdentificador());
		assertEquals("CCP2AN-MCA", lista.get(0).getSigla());
	}
	
	@Test
	void testInsertDeleteTurmas() {
		turma.setSemestreLetivo(1);
		turma.setAnoLetivo(2020);
		turma.setSigla("CPM2-LCS");
		Tema tema = new Tema();
		tema.setTema_id(2);
		turma.setCodigoIdentificador(5);
		
		turma.setTurmaTema(tema);
		turmaDao.cadastrarTurma(turma);
		
		ArrayList<Turma> lista = turmaDao.getTurmasByPeriodo(turma);
		assertEquals(5, lista.get(0).getCodigoIdentificador());
		assertEquals("CPM2-LCS", lista.get(0).getSigla());
		
		turmaDao.deleteTurma(turma);
		lista = turmaDao.getTurmasByPeriodo(turma);
		assertEquals(true, lista.isEmpty());
	}
	

}
