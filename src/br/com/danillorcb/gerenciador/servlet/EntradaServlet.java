package br.com.danillorcb.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

import br.com.danillorcb.gerenciador.acao.Acao;
import br.com.danillorcb.gerenciador.acao.AcaoStrategy;

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
			strategy = (AcaoStrategy) Class.forName("br.com.danillorcb.gerenciador.acao." + paramAcao).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Acao acao = new Acao();	
		acao.executa(request, response, strategy);
	}

}
