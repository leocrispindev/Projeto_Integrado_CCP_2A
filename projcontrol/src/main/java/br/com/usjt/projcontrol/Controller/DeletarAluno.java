package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;

public class DeletarAluno implements Acao{
	
	Gson json = new Gson();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("usu_id"));
		
		ServiceAluno serviceAluno = new ServiceAluno();
		
		String[] retorno = serviceAluno.setDelete(id);
		
		String result = json.toJson(retorno);
		
		return "json::"+result;

	}

}
