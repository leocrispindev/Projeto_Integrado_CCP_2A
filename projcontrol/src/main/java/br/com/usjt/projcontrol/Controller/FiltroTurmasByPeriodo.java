package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceTurma;
import br.com.usjt.projcontrol.model.Turma;

public class FiltroTurmasByPeriodo implements Acao{

	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Turma turma = new Turma();
		int ano = Integer.parseInt(request.getParameter("ano_letivo"));
		int semestre = Integer.parseInt(request.getParameter("semestreLetivo"));
		turma.setAnoLetivo(ano);
		turma.setSemestreLetivo(semestre);
		
		ArrayList<Turma> listaTurmas = new ArrayList<>();
		ServiceTurma st = new ServiceTurma();
		listaTurmas = st.getListaTurmasByPeriodo(turma);
		String retorno = json.toJson(listaTurmas);
		
		return "json::"+retorno;
	}

}
