package br.com.danillorcb.servlets.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.servlets.dao.EmpresaDAO;

public class RemoveEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");		
		Integer id = Integer.valueOf(paramId);
		
		EmpresaDAO dao = new EmpresaDAO();
		dao.excluir(id);
		
		return "redirect:ListaEmpresas";
	}

}
