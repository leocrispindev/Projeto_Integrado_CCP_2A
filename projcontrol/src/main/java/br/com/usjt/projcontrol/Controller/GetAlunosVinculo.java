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

public class GetAlunosVinculo implements Acao{
	Gson json = new Gson();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Turma turma = new Turma();
		
		int semestre = Integer.parseInt(request.getParameter("semestre"));
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		turma.setAnoLetivo(ano);
		turma.setSemestreLetivo(semestre);
		ServiceAluno serviceAluno = new ServiceAluno();
		ArrayList<Aluno> arrayAlunos = new ArrayList<Aluno>();
		
		arrayAlunos = serviceAluno.getAlunosVinculo(turma);
		
		String retornoAlunos = json.toJson(arrayAlunos);
		
		return "json::"+retornoAlunos;
	}
}
