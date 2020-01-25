package br.com.danillorcb.servlets.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.servlets.dao.EmpresaDAO;
import br.com.danillorcb.servlets.model.Empresa;

public class AlteraEmpresa implements AcaoStrategy {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		String paramData = request.getParameter("data");
		Date data = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			data = format.parse(paramData);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		EmpresaDAO dao = new EmpresaDAO();
		Empresa empresa = dao.findById(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(data);
		
		return "redirect:listaEmpresas";		
	}

}
