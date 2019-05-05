package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceJavaMailApp;

public class EnviarEmailCadastrar implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Gson json = new Gson();
		
		String email,nome;
		
		email = request.getParameter("env_email");
		nome = request.getParameter("env_nome");
		
		System.out.println(nome);
		
		ServiceJavaMailApp javamail = new ServiceJavaMailApp();
		String[] msg = javamail.enviaEmail(email,"mensagemCadastro", nome);
		
		String result = json.toJson(msg);
		System.out.println("seu result" + result);
		return "json::"+result;
	}
	
}
