package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceGrupo;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Turma;

public class GetGruposByAluno implements Acao{
	
	Gson json = new Gson();
	ArrayList<Grupo> grupos = new ArrayList<>();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int ano = Integer.parseInt(request.getParameter("anoLetivo"));
		int semestre = Integer.parseInt(request.getParameter("semestreLetivo"));
		
		Aluno aluno = new Aluno();
		aluno.setId(id);
		
		ServiceGrupo sg = new ServiceGrupo();
		ArrayList<Grupo> grupos = sg.getGruposByAluno(aluno, ano, semestre);
		String retorno = json.toJson(grupos);
		
		return "json::"+retorno;
	}
}