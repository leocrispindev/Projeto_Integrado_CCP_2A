package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.model.Atividade;

public class GetAtividadesByPeriodo implements Acao{

	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int ano = Integer.parseInt(request.getParameter("anoLetivo"));
		int semestre = Integer.parseInt(request.getParameter("semestreLetivo"));
		
		ServiceAluno service = new ServiceAluno();
		ArrayList<Atividade> avaliacoesFiltradas = service.getAtividadeByAlunoPeriodoLetivo(id, ano, semestre);
		String retorno = json.toJson(avaliacoesFiltradas);
		return "json::"+retorno;
	}
	

}
