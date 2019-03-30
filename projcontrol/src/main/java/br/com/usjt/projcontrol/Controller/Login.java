package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.model.Aluno;

public class Login implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String login, senha;
		
		login = request.getParameter("usu_email");
		senha = request.getParameter("usu_senha");
	
		ServiceAluno serviceAluno = new ServiceAluno();
		Aluno aluno = new Aluno();
		aluno.setEmail(login);
		aluno.setSenha(senha);
		
		Aluno alunoSession = new Aluno();
		alunoSession = serviceAluno.setCredencaisLogin(aluno);
		
		if(alunoSession.getId() != 0) {
			request.setAttribute("alunoDados", alunoSession);
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", alunoSession);
			
			return "forward:view/dashBoardAluno.jsp";
		}else {
			return "acessonegado:index.jsp";
		}
		
	}
	
}
