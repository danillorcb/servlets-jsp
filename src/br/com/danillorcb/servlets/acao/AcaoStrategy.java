package br.com.danillorcb.servlets.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AcaoStrategy {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}