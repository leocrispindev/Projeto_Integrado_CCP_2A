package br.com.usjt.projcontrol.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.usjt.projcontrol.model.Atividade;

class AtividadeDAOTest {
	
	private AtividadeDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new AtividadeDAO();
	}

	@Test
	void testGetAtividades() {
		ArrayList<Atividade> lista = dao.getAtividades();
		assertEquals(1, lista.get(0).getAtividadeId());
		assertEquals(1, lista.get(0).getTema().getTema_id());
		assertEquals(4, lista.get(3).getAtividadeId());
		
		for (Atividade atividade : lista) {
			System.out.println("ID:" + atividade.getAtividadeId() + " | " 
					+ "Tema ID:" + atividade.getTema().getTema_id() + " | " 
					+ "Descrição:" + atividade.getDescricao() + " | " 
					+ "Formato:" + atividade.getFormato() + " | "
					+ "Data início:" + atividade.getDataInicio().toString() + " | "
					+ "Data Fim:" + atividade.getDataFim().toString());
		}
	}
}
