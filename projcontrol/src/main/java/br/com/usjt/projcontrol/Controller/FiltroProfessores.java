package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceProfessor;
import br.com.usjt.projcontrol.model.Professor;

public class FiltroProfessores implements Acao{

	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ArrayList<Professor> listaProfessores = new ArrayList<>();
		ServiceProfessor sp = new ServiceProfessor();
		listaProfessores = sp.getListaProfessores();
		String retorno = json.toJson(listaProfessores);
		
		return "json::"+retorno;
	}

}
