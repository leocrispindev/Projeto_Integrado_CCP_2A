package br.com.usjt.projcontrol.Service;

import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.TemaDAO;
import br.com.usjt.projcontrol.model.Tema;

public class ServiceTema {

	private TemaDAO temaDAO;

	public ServiceTema() {
		temaDAO = new TemaDAO();
	}

	public ArrayList<Tema> getTemas() {
		ArrayList<Tema> temas = new ArrayList<>();
		temas = temaDAO.getTema();

		return temas;
	}
}
