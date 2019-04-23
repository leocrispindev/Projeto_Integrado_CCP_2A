package br.com.usjt.projcontrol.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.Service.ServiceProfessor;
import br.com.usjt.projcontrol.Service.ServiceTurma;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Professor;
import br.com.usjt.projcontrol.model.Turma;

public class Login implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String login, senha, acesso;
		
		login = request.getParameter("usu_email");
		senha = request.getParameter("usu_senha");
		acesso = request.getParameter("usuario_acesso");
		
		if(acesso.equals("Aluno")) {
			return loginAluno(request, login, senha);
			
		}else {
			return loginAdministrador(request, login, senha);
		}
		
	}
	
	public static String loginAluno(HttpServletRequest request,String email, String senha) {
		ServiceAluno serviceAluno = new ServiceAluno();
		
		Aluno aluno = new Aluno();
		aluno.setEmail(email);
		aluno.setSenha(senha);
		
		Aluno alunoSession = new Aluno();
		alunoSession = serviceAluno.setCredencaisLogin(aluno);
		
		if(alunoSession.getId() != 0) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", alunoSession);
			request.setAttribute("alunoDados", alunoSession);
			
			ArrayList<Turma> turmas = new ArrayList<Turma>();
			turmas = serviceAluno.getTurmasByAluno(alunoSession.getId());
			
			request.setAttribute("turmasDados", turmas);
			
			return "forward::view/dashBoardAluno.jsp";
		}else {
			return "acessonegado::index.jsp";
		}
	}
	
	public static String loginAdministrador(HttpServletRequest request,String email, String senha) {
		ServiceProfessor serviceProfessor = new ServiceProfessor();
		
		Professor professor = new Professor();
		professor.setEmail(email);
		professor.setSenha(senha);
		
		Professor professorSession = new Professor();
		professorSession = serviceProfessor.setCredencaisLogin(professor);
		
		if(professorSession.getId() != 0) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("professorLogado", professorSession);
			request.setAttribute("professorDados", professorSession);
			
			//ArrayList<Turma> turmas = new ArrayList<Turma>();
			//turmas = professorAluno.getTurmasByAluno(professorSession.getId());
			
			//request.setAttribute("turmasDados", turmas);
			
			return "forward::view/dashboardProfessor.jsp";
		}else {
			return "acessonegado::index.jsp";
		}
	}
	
}
