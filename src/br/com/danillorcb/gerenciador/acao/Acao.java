package br.com.danillorcb.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Acao {

	public void executa(HttpServletRequest request, HttpServletResponse response, AcaoStrategy acao) throws ServletException, IOException {
		acao.executa(request, response);
	}
}
