package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Professor;

class ProfessorDAOTest {
	
	private Professor professor;
	private ProfessorDAO dao;
	private ArrayList<Professor> lista;

	@BeforeEach
	void setUp() throws Exception {
		professor = new Professor();
		dao = new ProfessorDAO();
	}
	
	@Test
	void testLoginProfessorDeveRetornarDados() {
		//O login vai retornar os dados somente se o professor for admnistrador
		professor.setEmail("prof.thiago@teste.com");
		professor.setSenha("Professor123@");
		professor = dao.loginProfessor(professor);
		
		Professor p1 = new Professor();
		p1.setId(6);
		p1.setNome("Professor Thiago");
		p1.setEmail("prof.thiago@teste.com");
		p1.setSenha("Professor123@");
		
		assertEquals(p1, professor);
		System.out.println("Login:" + professor);
	}
	
	@Test
	void testUpdateEmailSenha() {
		professor.setEmail("prof.pedro@teste.com");
		professor.setSenha("Professor123@");
		professor = dao.loginProfessor(professor);
		
		System.out.println("Dados:" + professor);
		
		//Update de email e senha
		professor.setEmail("prof.pedro_yamamoto@yahoo.com");
		professor.setSenha("1234A@");
		dao.updateProfessor(professor);
		professor = dao.loginProfessor(professor);
		
		Professor p1 = new Professor();
		p1.setEmail("prof.pedro_yamamoto@yahoo.com");
		p1.setSenha("1234A@");
		p1.setId(7);
		p1.setNome("Professor Pedro");

		assertEquals(p1, professor);
		System.out.println("Update:" + professor);
	}
	
	@Test
	void testDeleteProfessor() {
		professor.setEmail("prof.thiago@teste.com");
		professor.setSenha("Professor123@");
		professor = dao.loginProfessor(professor);
		
		Professor p1 = new Professor();
		dao.deleteProfessor(professor.getId());
		professor = dao.loginProfessor(professor);
		
		assertEquals(p1, professor);
		System.out.println("Delete:" + professor);
	}

	@Test
	void testArrayProfessores() {
		lista = new ArrayList<Professor>();
		lista = dao.getProfessores();
		
		System.out.println("");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId() + " " + lista.get(i).getNome());
		}
	}

}
