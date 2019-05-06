package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.model.Turma;

public class GetTurmasByAluno implements Acao {
	
	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int ano = Integer.parseInt(request.getParameter("anoLetivo"));
		int semestre = Integer.parseInt(request.getParameter("semestreLetivo"));
		
		ServiceAluno sa = new ServiceAluno();
		ArrayList<Turma> turmas = sa.getTurmasByAlunoPeriodoLetivo(id, ano, semestre);
		String retorno = json.toJson(turmas);
		return "json::"+retorno;
	}
	

}
