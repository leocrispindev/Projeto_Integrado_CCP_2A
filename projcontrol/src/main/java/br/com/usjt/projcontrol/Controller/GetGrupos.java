package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceGrupo;
import br.com.usjt.projcontrol.model.Grupo;

public class GetGrupos implements Acao {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Gson json = new Gson();
		ArrayList<Grupo> grupos = new ArrayList<>();
		
		String professor = request.getParameter("professorId");
		String turma = request.getParameter("turmaId");
		
		ServiceGrupo service = new ServiceGrupo();
		grupos = service.getGruposByProfTurma(professor, turma);
		String retorno = json.toJson(grupos);
		
		return "json::"+retorno;
	}

}
