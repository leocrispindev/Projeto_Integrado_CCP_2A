package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Turma;
/**
 * Testes persistência com o JUnit tendem a sofrer erros quando executados mais de uma vez
 * pois é uma framework limitada. Campos únicos podem sofrer erros de constraint pois o teste 
 * de insert pode inserir o mesmo email duas vezes, por exemplo. O ideal para testes de persistência
 * seria o uso de ferramentas que possam simular o estado do banco de dados atual e realizar
 * os CRUDs sem causar alterações no banco de dados.
 *
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class AlunoDAOTest {
	
	private AlunoDAO dao;
	private Aluno aluno, alunoLogin;
	private static int id;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new AlunoDAO();
		aluno = new Aluno();
		alunoLogin = new Aluno();
		
		aluno.setId(id);
		aluno.setRa(Integer.MAX_VALUE);
		aluno.setNome("Jonathan Joestar");
		aluno.setEmail("jon_test@hotmail.com");
		aluno.setSenha("USJT@2019");
		
		alunoLogin.setEmail("jon_test@hotmail.com");
		alunoLogin.setSenha("USJT@2019");
	}
	
	@Test
	void test01Insert() {
		dao.cadastrarAluno(aluno);
		id = dao.getUsuarioID();
		aluno.setId(id);
		
		alunoLogin = dao.loginAluno(alunoLogin);
		
		assertEquals(aluno.getId(), alunoLogin.getId());	
		System.out.println("Insert:" + aluno);
	}
	
	@Test
	void test02Login() {
		alunoLogin = dao.loginAluno(alunoLogin);
		
		assertEquals(aluno, alunoLogin);
		System.out.println("Login:" + alunoLogin);
	}
	
	@Test
	void test03Update() {
		String email = "joestar_update@gmail.com";
		String senha = "saojudas@2019";
		aluno.setSenha(senha);
		aluno.setEmail(email);
		dao.updateAluno(aluno);
		
		alunoLogin = dao.loginAluno(aluno);
		
		assertEquals(aluno, alunoLogin);
		System.out.println("Update:" + alunoLogin);
	}
	
	@Test
	void test04Delete() {
		aluno = null;
		
		alunoLogin.setEmail("joestar_update@gmail.com");
		alunoLogin.setSenha("saojudas@2019");
		alunoLogin = dao.loginAluno(alunoLogin);
		
		boolean deletado = dao.deleteAluno(alunoLogin.getId());
		
		alunoLogin = dao.loginAluno(alunoLogin);
		
		assertEquals(true, deletado);
		assertEquals(0, alunoLogin.getId());
		System.out.println("Delete:" + alunoLogin);
	}
	
	@Test
	void test05TurmasPorAlunoId() {
		Aluno alunoMartin = new Aluno();
		alunoMartin.setEmail("martin@hotmail.com");
		alunoMartin.setSenha("Aluno123@");
		alunoMartin = dao.loginAluno(alunoMartin);
		
		ArrayList<Turma> lista = dao.getTurmasByAlunoID(alunoMartin.getId());
		
		String sigla = "CCP1AN-MCA";
		
		assertEquals(sigla, lista.get(0).getSigla());
		
		for (Turma turma : lista) {
			System.out.println(turma.getSigla() + " | " 
					+ turma.getTurmaTema().getTitulo() + " | " 
					+ turma.getTurmaTema().getIntroducao());
		}
	}
	
	@Test
	void test06ListarAllAlunos() {
		ArrayList<Aluno> allAlunos = dao.getAllAlunos();
		int tamanho = allAlunos.size();
		
		assertEquals(81811011, allAlunos.get(0).getRa());
		assertEquals(81811110, allAlunos.get(tamanho - 1).getRa());
	}
	
	@Test
	void test07DadosByAlunoId() {
		Aluno alunoDados = dao.getDadosAlunoById(11);
		System.out.println("Dados por ID: " + alunoDados);
		
		Aluno alunoTest = new Aluno();
		alunoTest.setEmail("martin@hotmail.com");
		
		assertEquals(alunoTest.getEmail(), alunoDados.getEmail());
	}
	
	@Test
	void test08GruposByAlunoId() {
		ArrayList<Grupo> grupos = dao.getGruposByAlunoId(11);
		
		assertEquals(1, grupos.get(0).getId());
		assertEquals(6, grupos.get(1).getId());
		assertEquals(11, grupos.get(2).getId());
		assertEquals(16, grupos.get(3).getId());
	}
	
	@Test
	void test09AlunosByGruposId() {
		ArrayList<Aluno> listaAlunos = dao.getAlunosByGrupoId(1);
		
		assertEquals(81811011, listaAlunos.get(0).getRa());
		assertEquals(81811012, listaAlunos.get(1).getRa());
		assertEquals(81811013, listaAlunos.get(2).getRa());
	}
	
	@Test
	void test10PeriodoLetivoByAlunoId() {
		Aluno alunoTest = new Aluno();
		alunoTest.setId(12);
		ArrayList<Turma> periodos = dao.getPeriodoLetivoByAlunoId(alunoTest);
		
		assertEquals(2018, periodos.get(0).getAnoLetivo());
	}
	
	@Test
	void test11TurmasByAlunoIdPeriodo() {
		ArrayList<Turma> listaTurmas = dao.getTurmasByAlunoIdPeriodoLetivo(11, 2019, 1);
		assertEquals("CCP2AN-MCA", listaTurmas.get(0).getSigla());
		assertEquals("Projeto Integrado", listaTurmas.get(0).getTurmaTema().getTitulo());
		assertEquals("Desenvolver projeto integrando conteúdo de todo o semestre.", listaTurmas.get(0).getTurmaTema().getIntroducao());
	}
}
