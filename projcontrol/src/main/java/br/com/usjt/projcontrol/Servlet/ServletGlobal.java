package br.com.usjt.projcontrol.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Acao;

@WebServlet(urlPatterns = "/entrada")
public class ServletGlobal extends HttpServlet {

	private String operacao, classPath;
	private static final long serialVersionUID = 1L;

	public ServletGlobal() {
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {

			operacao = request.getParameter("acao");
			classPath = "br.com.usjt.projcontrol.Controller." + operacao;

			Class classe = Class.forName(classPath);
			Acao acao = (Acao) classe.newInstance();

			String dados = acao.executa(request, response);
			String url = "/projectcontrol/" + operacao + ".jsp";
			response.sendRedirect(url);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
		String[] tipoEndereco = nome.split(":");
		if (tipoEndereco[0].equals("foword")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}

	}
}
