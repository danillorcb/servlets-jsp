package br.com.danillorcb.servlets.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response, AcaoStrategy acao) throws ServletException, IOException {
		return acao.executa(request, response);
	}
}
