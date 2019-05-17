package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CredenciaisDAOTest {
	
	private CredenciaisDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new CredenciaisDAO();
	}

	@Test
	void testGetAllEmails() {
		ArrayList<String> listarEmails = dao.getAllEmails();
		
		for (String string : listarEmails) 
			System.out.println(string);
		
		assertEquals("anthony@hotmail.com", listarEmails.get(0));
	}
}
