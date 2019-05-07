package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceJavaMailApp;

public class GetEmailTrocaSenha implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Gson json = new Gson();
		
		String email;

		email = request.getParameter("email");
//		System.out.println("email que chegou " + email);
		
		ServiceJavaMailApp serviceEnviaEmail = new ServiceJavaMailApp();

		String[] msg = serviceEnviaEmail.enviaEmail(email,"mensagemRecuperarSenha",null);

		String result = json.toJson(msg);
		
		return "json::"+result;
	}

}
