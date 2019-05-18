package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.Service.ServiceTurma;

public class DesvincularAlunoTurma implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int idAluno, idTurma; 
		String dados;
		
		idAluno = Integer.parseInt(request.getParameter("idAluno"));
		idTurma = Integer.parseInt(request.getParameter("idTurma"));
		
		ServiceTurma serviceTurma = new ServiceTurma(); 
		
		String[] retorno = serviceTurma.setDesvincularAlunoTurma(idAluno, idTurma);
		Gson json = new Gson();
		
		dados = json.toJson(retorno);
		
		return "json::"+dados;
	}

}
