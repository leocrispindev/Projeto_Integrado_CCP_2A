package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceAluno;
import br.com.usjt.projcontrol.model.Aluno;

public class CadastrarAluno implements Acao{
	Gson json = new Gson();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException { 
			
		String nome, email, senha;
		int ra;
		
		nome = request.getParameter("usu_nome");
		email = request.getParameter("usu_email");
		senha = request.getParameter("usu_senha");
		
		try {
			ra = Integer.parseInt(request.getParameter("usu_ra"));
		}catch(Exception e) {
			String[] retorno = {"Erro!","Preencha os dados corretamente.", "error"};
			
			String result = json.toJson(retorno);
			
			return "json:"+result;
		}
		
		
		ServiceAluno serviceAluno = new ServiceAluno();
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setSenha(senha);
		aluno.setRa(ra);
		
		String[] retorno = serviceAluno.setCadastro(aluno);
		
		String result = json.toJson(retorno);
		
		return "json:"+result;
	}
	
}
