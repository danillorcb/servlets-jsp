package br.com.danillorcb.servlets.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.util.StringUtils;

import br.com.danillorcb.servlets.acao.Acao;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Usando parâmetro via get (/entrada?acao=)
		String paramAcao = request.getParameter("acao");
		
		// Usando parâmetro via recurso (/recurso)
//		String[] split = request.getRequestURI().split("/");
//		String paramAcao = split[split.length-1];
//		paramAcao = StringUtils.capitalize(paramAcao);
		
		// Instanciando a classe que implementa Acao e chamando o método executa()
		String nomeDaClasse = "br.com.danillorcb.servlets.acao." + paramAcao;
		String destino;
		try {
			Acao acao = (Acao) Class.forName(nomeDaClasse).newInstance();
			destino = acao.executa(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		String[] encaminhamento = destino.split(":");		
		if (encaminhamento[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + encaminhamento[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("entrada?acao=" + encaminhamento[1]);
		}
	}

}
