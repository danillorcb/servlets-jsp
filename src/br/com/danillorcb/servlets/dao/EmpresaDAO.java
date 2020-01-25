package br.com.danillorcb.servlets.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.danillorcb.servlets.model.Empresa;

public class EmpresaDAO {

	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer idSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(idSequencial++);
		empresa1.setNome("Amazon");
		empresas.add(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(idSequencial++);
		empresa2.setNome("Google");
		empresas.add(empresa2);
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(idSequencial++);
		empresas.add(empresa);
	}
	
	public List<Empresa> listar() {
		return empresas;
	}
	
	public void excluir(Integer id) {
		
		Iterator<Empresa> it = empresas.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = it.next();
			
			if (empresa.getId() == id) {
				it.remove();
			}
		}
	}
	
	public void alterar(Empresa empresa) {
		if (empresas.contains(empresa)) {
			empresas.remove(empresa);
			empresas.add(empresa);
		}
	}

	public Empresa findById(Integer id) {
		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
}
