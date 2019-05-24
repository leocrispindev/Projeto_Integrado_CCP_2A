package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAvaliacao;
import br.com.usjt.projcontrol.model.Avaliacao;

public class VisualizarAvaliacaoDetalhes implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int avaliacaoId = Integer.parseInt(request.getParameter("avaliacaoId"));
		
		Gson json = new Gson();
		ServiceAvaliacao service = new ServiceAvaliacao();
		ArrayList<Avaliacao> avaliacaoDetalhes = service.getAvaliacaoDetalhes(avaliacaoId);
		
		String retorno = json.toJson(avaliacaoDetalhes);
		
		return "json::"+retorno;
	}

}