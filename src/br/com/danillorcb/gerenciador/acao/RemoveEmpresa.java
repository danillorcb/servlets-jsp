package br.com.danillorcb.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.gerenciador.dao.EmpresaDAO;

public class RemoveEmpresa implements AcaoStrategy {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");		
		Integer id = Integer.valueOf(paramId);
		
		EmpresaDAO dao = new EmpresaDAO();
		dao.excluir(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
