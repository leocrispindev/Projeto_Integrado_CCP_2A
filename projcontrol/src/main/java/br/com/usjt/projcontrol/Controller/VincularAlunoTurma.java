package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.Service.ServiceTurma;
import br.com.usjt.projcontrol.model.Aluno;

public class VincularAlunoTurma implements Acao{
	Gson json = new Gson();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException { 
			
		String ids;
		int turmaId;
		
		ids = request.getParameter("alunosIds");
		turmaId = Integer.parseInt(request.getParameter("turma_id"));
		
		ServiceTurma serviceTurma = new ServiceTurma();
		
		String[] retorno = serviceTurma.setVinculoAlunoTurma(ids, turmaId);
		
		String result = json.toJson(retorno);
		
		return "json::"+result;
	}
}
