package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceCredenciais;
import br.com.usjt.projcontrol.model.Aluno;

public class UpdateCredenciais implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		Aluno aluno = (Aluno) session.getAttribute("usuarioLogado");
		
		String email = request.getParameter("campo");
		String confirm_email = request.getParameter("confirm_campo");
		String tipoUpdate = request.getParameter("update");
		
		ServiceCredenciais credenciais = new ServiceCredenciais();
		
		String[] retorno = credenciais.setUpdateCredenciais(email, confirm_email, aluno.getId(), tipoUpdate);
		
		Gson json = new Gson();
		String result = json.toJson(retorno);
		
		return "json::"+result;

	}
}
