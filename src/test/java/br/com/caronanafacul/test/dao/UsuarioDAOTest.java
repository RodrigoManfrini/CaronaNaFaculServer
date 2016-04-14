package br.com.caronanafacul.test.dao;

import br.com.caronanafacul.dao.DAOException;
import br.com.caronanafacul.dao.UsuarioDAO;
import br.com.caronanafacul.model.Usuario;

public class UsuarioDAOTest {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// TODO criar um método pra cada teste

		 try {
			usuarioDAO.save(new Usuario("usuario2@test", "faculdade aqui"));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Usuario usuario = usuarioDAO.findById(1);

//		Usuario usuario = usuarioDAO.findByEmail("email@test");
//
//		System.out.println(usuario);

	}

}