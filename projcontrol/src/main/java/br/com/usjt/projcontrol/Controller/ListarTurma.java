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

public class ListarTurma implements Acao {
	
	Gson json = new Gson();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ServiceTurma serviceTurma = new ServiceTurma();
		ArrayList<Turma> arrayTurma = new ArrayList<Turma>();
		
		arrayTurma = serviceTurma.getListaTurmas();
		
		String retorno = json.toJson(arrayTurma);
		
		return "json::" + retorno;
	}
}
