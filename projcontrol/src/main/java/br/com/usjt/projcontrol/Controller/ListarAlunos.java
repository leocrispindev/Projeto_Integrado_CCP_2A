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

public class ListarAlunos implements Acao {

	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ServiceAluno serviceAluno = new ServiceAluno();
		ArrayList<Aluno> arrayAlunos = new ArrayList<Aluno>();
		
		arrayAlunos = serviceAluno.getListaAllAlunos();
		
		String retornoAlunos = json.toJson(arrayAlunos);
		
		return "json::"+retornoAlunos;
	}

}
