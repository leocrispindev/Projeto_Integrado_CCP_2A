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

public class FiltroProfessoresByPeriodo implements Acao{
	
	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int ano = Integer.parseInt(request.getParameter("anoLetivo"));
		int semestre = Integer.parseInt(request.getParameter("semestreLetivo"));
		
		ArrayList<Professor> professores = new ArrayList<>();
		ServiceProfessor service = new ServiceProfessor();
		professores = service.getListaProfessoresByPeriodo(ano, semestre);
		String retorno = json.toJson(professores);
		
		return "json::"+retorno;
	}

}
