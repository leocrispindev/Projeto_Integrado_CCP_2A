package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceTurma;
import br.com.usjt.projcontrol.model.Tema;
import br.com.usjt.projcontrol.model.Turma;

public class CadastrarTurma implements Acao{
	
	Gson json = new Gson();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String sigla;
		int anoLetivo;
		int semestreLetivo;
		Tema turmaTema = new Tema();
	
		sigla = request.getParameter("sigla");
		turmaTema.setTema_id(Integer.parseInt(request.getParameter("tema")));
		
		try {
			anoLetivo = Integer.parseInt(request.getParameter("anoLetivo"));
			semestreLetivo = Integer.parseInt(request.getParameter("semestreLetivo"));
		}catch(Exception e) {
			String[] retorno = {"Erro!","Preencha os dados corretamente.", "error"};
			
			String result = json.toJson(retorno);
			
			return "json::"+result;
		}
		
		ServiceTurma serviceTurma = new ServiceTurma();
		
		Turma turma = new Turma();
		turma.setSigla(sigla);
		turma.setAnoLetivo(anoLetivo);
		turma.setSemestreLetivo(semestreLetivo);
		turma.setTurmaTema(turmaTema);
		
		String[] retorno = serviceTurma.setCadastro(turma);
		
		String result = json.toJson(retorno);
		
		
		return "json::" + result;
	}

}
