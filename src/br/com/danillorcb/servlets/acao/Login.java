package br.com.danillorcb.servlets.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.danillorcb.servlets.dao.UsuarioDAO;
import br.com.danillorcb.servlets.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.existeUsuario(login, senha);
		
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			return "redirect:ListaEmpresas";
		} else {
			return "redirect:LoginForm";
		}
	}

}
