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
import br.com.usjt.projcontrol.model.Turma;

public class GetPeriodoLetivoByAluno implements Acao{
	
	Gson json = new Gson();
	ArrayList<Turma> periodo = new ArrayList<>();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {		
		Aluno aluno = new Aluno();
		int id = Integer.parseInt(request.getParameter("id"));
		aluno.setId(id);
		
		ServiceAluno sa = new ServiceAluno();
		periodo = sa.getPeriodoLetivoByAlunoId(aluno);
		String retorno = json.toJson(periodo);
		
		return "json::"+retorno;
	}
}