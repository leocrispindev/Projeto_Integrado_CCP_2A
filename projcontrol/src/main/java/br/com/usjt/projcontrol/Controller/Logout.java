package br.com.usjt.projcontrol.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.projcontrol.Interface.Acao;

public class Logout implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		sessao.removeAttribute("usuarioLogado");
		sessao.invalidate();
		
		return "forward::index.jsp";
	}

}
