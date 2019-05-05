package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceTema;
import br.com.usjt.projcontrol.model.Tema;

public class GetTema implements Acao{
	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ArrayList<Tema> temas = new ArrayList<Tema>();
		ServiceTema serviceTema = new ServiceTema();
		temas = serviceTema.getTemas();
		
		String retorno = json.toJson(temas);

		return "json::" + retorno;
	}

}
