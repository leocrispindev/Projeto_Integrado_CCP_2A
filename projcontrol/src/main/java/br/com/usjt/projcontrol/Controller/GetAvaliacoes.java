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

public class GetAvaliacoes implements Acao{
	ArrayList<Avaliacao> retornoAvaliacoes = new ArrayList<Avaliacao>();
	Gson json = new Gson();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ServiceAvaliacao av = new ServiceAvaliacao();
		
		retornoAvaliacoes = av.getAvaliacoes();
		String retorno = json.toJson(retornoAvaliacoes);
		
		return "json::"+retorno;
	}

}
