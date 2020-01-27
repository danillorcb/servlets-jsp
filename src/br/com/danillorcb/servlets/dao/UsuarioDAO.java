package br.com.danillorcb.servlets.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.danillorcb.servlets.model.Usuario;

public class UsuarioDAO {

	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		Usuario u1 = new Usuario();
		u1.setLogin("usuario1");
		u1.setSenha("123");
		
		Usuario u2 = new Usuario();
		u2.setLogin("usuario2");
		u2.setSenha("123");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
