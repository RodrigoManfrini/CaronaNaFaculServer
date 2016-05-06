package br.com.caronanafacul.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.caronanafacul.dao.DAOException;
import br.com.caronanafacul.dao.UsuarioDAO;
import br.com.caronanafacul.model.Usuario;

@Path(value = "/usuario")
public class UsuarioController {
	
	//TODO usar injeção de dependência
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	//TODO método pra login
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario getByFacebookId(Usuario usuario) throws DAOException{
		Usuario usuarioBanco = usuarioDAO.findByFacebookId(usuario.getFacebookId());
		if(usuarioBanco == null){
			usuarioBanco = (Usuario) usuarioDAO.merge(usuario);
		}
		return usuarioBanco;
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