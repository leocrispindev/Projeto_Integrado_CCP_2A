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

public class GetPeriodoLetivo implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Gson json = new Gson();
		ArrayList<Turma> periodos = new ArrayList<>();
		ServiceTurma service = new ServiceTurma();
		periodos = service.getAllPeriodosLetivos();
		String retorno = json.toJson(periodos);
		return "json::"+retorno;
	}

}
