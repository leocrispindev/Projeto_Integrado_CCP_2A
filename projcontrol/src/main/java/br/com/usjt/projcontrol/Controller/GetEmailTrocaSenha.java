package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.projcontrol.Interface.Acao;
import br.com.usjt.projcontrol.Service.ServiceJavaMailApp;

public class GetEmailTrocaSenha implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		String email;

		email = request.getParameter("emailRecuperarSenha");
		
		ServiceJavaMailApp serviceEnviaEmail = new ServiceJavaMailApp();

		serviceEnviaEmail.enviaEmail(email);

		return "forward::index.jsp";
	}

}
