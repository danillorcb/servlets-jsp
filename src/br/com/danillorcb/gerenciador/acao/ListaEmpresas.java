package br.com.danillorcb.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.gerenciador.dao.EmpresaDAO;
import br.com.danillorcb.gerenciador.model.Empresa;

public class ListaEmpresas implements AcaoStrategy {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaDAO dao = new EmpresaDAO();
		List<Empresa> empresas = dao.listar();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		request.setAttribute("empresas", empresas);
		rd.forward(request, response);
	}

}
