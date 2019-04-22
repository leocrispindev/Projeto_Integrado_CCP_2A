package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.usjt.projcontrol.model.Aluno;
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
	private Aluno aluno1, aluno2;
	private static int id;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new AlunoDAO();
		aluno1 = new Aluno();
		aluno2 = new Aluno();
		
		aluno1.setId(id);
		aluno1.setRa(Integer.MAX_VALUE);
		aluno1.setNome("Joaquim do Insert");
		aluno1.setEmail("test01@hotmail.com");
		aluno1.setSenha("AlunoTest123@");
		
		aluno2.setEmail("test01@hotmail.com");
		aluno2.setSenha("AlunoTest123@");
	}
	
	@Test
	void test01Insert() {
		dao.cadastrarAluno(aluno1);
		id = dao.getUsuarioID();
		aluno1.setId(id);
		
		assertEquals(aluno1.getId(), dao.getUsuarioID());	
		System.out.println("Insert:" + aluno1);
	}
	
	@Test
	void test02Login() {
		aluno2 = dao.loginAluno(aluno2);
		
		assertEquals(aluno1, aluno2);
		System.out.println("Login:" + aluno2);
	}
	
	@Test
	void test03Update() {
		aluno2 = dao.loginAluno(aluno2);
		
		String email = "update@gmail.com";
		aluno2.setEmail(email);
		dao.updateAluno(aluno2);
		
		assertEquals(email, dao.loginAluno(aluno2).getEmail());
		System.out.println("Update:" + aluno2);
	}
	
	@Test
	@Disabled("Cannot delete or update a parent row: a foreign key constraint fails")
	void test04Delete() {
		aluno1 = null;
		aluno2.setEmail("update@gmail.com");
		aluno2.setSenha("AlunoTest123@");
		aluno2 = dao.loginAluno(aluno2);
		dao.deleteAluno(aluno2.getId());
		
		assertEquals(aluno1, aluno2);
		System.out.println("Delete:" + aluno2);
	}
	
	@Test
	void test05ArrayDeTurmasPorAlunoId() {
		Aluno a = new Aluno();
		a.setEmail("martin@hotmail.com");
		a.setSenha("Aluno123@");
		a = dao.loginAluno(a);
		
		ArrayList<Turma> lista = new ArrayList<Turma>();
		lista = dao.getTurmasByAlunoID(a.getId());
		
		String sigla = "CCP1AN-MCA";
		
		assertEquals(sigla, lista.get(0).getSigla());
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getSigla() + " | " + lista.get(i).getTurmaTema().getTitulo() + " | " + lista.get(i).getTurmaTema().getIntroducao());
		}
	}
}
