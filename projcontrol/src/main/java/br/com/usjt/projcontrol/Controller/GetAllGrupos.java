package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceGrupo;
import br.com.usjt.projcontrol.model.Grupo;

public class GetAllGrupos implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ArrayList<Grupo> allGrupos = new ArrayList<>();
		ServiceGrupo service = new ServiceGrupo();
		Gson json = new Gson();
		
		allGrupos = service.getListaGrupos();
		
		String retorno = json.toJson(allGrupos);
		
		return "json::"+retorno;
	}

}
