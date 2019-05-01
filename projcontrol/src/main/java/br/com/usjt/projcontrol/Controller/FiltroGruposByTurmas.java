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
import br.com.usjt.projcontrol.model.Turma;

public class FiltroGruposByTurmas implements Acao{
	
	Gson json = new Gson();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Turma turma = new Turma();
		int turmaId = Integer.parseInt(request.getParameter("codigoIdentificador"));
		turma.setCodigoIdentificador(turmaId);
		
		ServiceGrupo sg = new ServiceGrupo();
		ArrayList<Grupo> listaGrupos = sg.getListaGruposByTurmaId(turma);
		String retorno = json.toJson(listaGrupos);
		
		return "json::"+retorno;
	}
	

}
