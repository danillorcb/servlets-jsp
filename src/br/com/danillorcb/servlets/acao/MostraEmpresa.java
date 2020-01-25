package br.com.danillorcb.servlets.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.servlets.dao.EmpresaDAO;
import br.com.danillorcb.servlets.model.Empresa;

public class MostraEmpresa implements AcaoStrategy {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		EmpresaDAO dao = new EmpresaDAO();
		Empresa empresa = dao.findById(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";
	}

}
