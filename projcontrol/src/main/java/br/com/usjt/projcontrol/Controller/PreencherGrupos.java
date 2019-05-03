package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.model.Aluno;

public class PreencherGrupos implements Acao{

	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("grupoId"));
		
		ServiceAluno sa = new ServiceAluno();
		ArrayList<Aluno> alunos = new ArrayList<>();
		alunos = sa.getIntegrantesDoGrupo(id);
		String retorno = json.toJson(alunos);
		return "json::"+retorno;
	}

}
