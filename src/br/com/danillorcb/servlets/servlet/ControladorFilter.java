package br.com.danillorcb.servlets.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.servlets.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		// Usando parâmetro via get (/entrada?acao=)
//		String paramAcao = request.getParameter("acao");
		
		// Usando parâmetro via recurso (/recurso)
//		String[] split = request.getRequestURI().split("/");
//		String paramAcao = split[split.length-1];
//		paramAcao = StringUtils.capitalize(paramAcao);		
		
		System.out.println(this.getClass().getName());
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
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
