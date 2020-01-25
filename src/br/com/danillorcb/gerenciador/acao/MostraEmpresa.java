package br.com.danillorcb.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.gerenciador.dao.EmpresaDAO;
import br.com.danillorcb.gerenciador.model.Empresa;

public class MostraEmpresa implements AcaoStrategy {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		EmpresaDAO dao = new EmpresaDAO();
		Empresa empresa = dao.findById(id);
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

}
