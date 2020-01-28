package br.com.danillorcb.servlets.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.danillorcb.servlets.dao.EmpresaDAO;
import br.com.danillorcb.servlets.model.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmpresaDAO dao = new EmpresaDAO();
		List<Empresa> empresas = dao.listar();
		
		String accept = request.getHeader("accept");
		
		if (accept.contains("application/json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else if (accept.contains("application/xml")) {
			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else {
		    response.setContentType("application/json");
		    response.getWriter().print("{\"message\":\"no content\"}");
		}
	}

}
