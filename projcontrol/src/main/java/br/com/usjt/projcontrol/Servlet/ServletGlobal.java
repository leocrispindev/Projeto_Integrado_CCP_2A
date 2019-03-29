package br.com.usjt.projcontrol.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.projcontrol.Interface.Acao;


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

			String dados = acao.execute(request, response);
		
			String[] tipoEndereco = dados.split(":");
			if (tipoEndereco[0].equals("forward")) {
				
				//RequestDispatcher rd = request.getRequestDispatcher("view/" + tipoEndereco[1]);
				//rd.forward(request, response);
				response.sendRedirect("view/"+tipoEndereco[1]);
			} else if(tipoEndereco[0].equals("acessonegado")){
				response.sendRedirect(tipoEndereco[1]);
			}
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}
}
