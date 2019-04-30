package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAvaliacao;
import br.com.usjt.projcontrol.Service.ServiceTurma;
import br.com.usjt.projcontrol.model.Turma;

public class FiltroPeriodoLetivo implements Acao{
	
	Gson json = new Gson();
	ArrayList<Turma> ano = new ArrayList<>();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ServiceTurma st = new ServiceTurma();
		ano = st.getPeriodoLetivo();
		String retorno = json.toJson(ano);
		
		return "json::"+retorno;
	}
}
