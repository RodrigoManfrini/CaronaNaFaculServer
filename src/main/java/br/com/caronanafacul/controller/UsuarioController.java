package br.com.caronanafacul.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.caronanafacul.dao.DAOException;
import br.com.caronanafacul.dao.UsuarioDAO;
import br.com.caronanafacul.model.Usuario;

@Path(value = "/usuario")
public class UsuarioController {
	
	//TODO usar injeção de dependência
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void entrar(Usuario usuario) {
		
	}

	public void sair(Usuario usuario) {

	}
	
	public void cancelar(Usuario usuario){
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getByEmail(@QueryParam(value = "email") String email){
		return usuarioDAO.findByEmail(email);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void put(Usuario usuario){
		try {
			usuarioDAO.merge(usuario);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}