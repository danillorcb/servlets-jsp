package br.com.danillorcb.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.danillorcb.gerenciador.dao.EmpresaDAO;
import br.com.danillorcb.gerenciador.model.Empresa;

public class NovaEmpresa implements AcaoStrategy {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("nome");
		String paramData = request.getParameter("data");

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		EmpresaDAO dao = new EmpresaDAO();
		dao.adicionar(empresa);		
		
		// Redirecionamento server-side - para JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
		// Redirecionamento server-side - para Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/entrada?acao=ListaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
		// Redirecionamento client-side - para Servlet
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas");
	}

}
