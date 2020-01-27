package br.com.danillorcb.servlets.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.servlets.dao.EmpresaDAO;
import br.com.danillorcb.servlets.model.Empresa;

public class ListaEmpresas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaDAO dao = new EmpresaDAO();
		List<Empresa> empresas = dao.listar();
		
		request.setAttribute("empresas", empresas);
		
		return "forward:listaEmpresas.jsp";
	}

}
