package br.com.danillorcb.servlets.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

import br.com.danillorcb.servlets.acao.Acao;
import br.com.danillorcb.servlets.acao.AcaoStrategy;

@WebServlet("/")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Usando parâmetro via GET (/entrada?acao=)
//		String paramAcao = request.getParameter("acao");

		// Usando parâmetro via recurso (/recurso)
		String[] split = request.getRequestURI().split("/");
		String paramAcao = split[split.length-1];
		paramAcao = StringUtils.capitalize(paramAcao);
		
		AcaoStrategy strategy = null;
		try {
			strategy = (AcaoStrategy) Class.forName("br.com.danillorcb.servlets.acao." + paramAcao).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Acao acao = new Acao();	
		String destino = acao.executa(request, response, strategy);
		String[] encaminhamento = destino.split(":");
		
		if (encaminhamento[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/" + encaminhamento[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(encaminhamento[1]);
		}
	}

}
