package br.com.danillorcb.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AcaoStrategy {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}